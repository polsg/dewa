$main.find('#saveEmp').live('click',function(){	
	empTemp.guardar()
});
$main.find('#editEmp').live('click',function(){	 
	var id = $(this).attr('data-id'); 
	empTemp.getEmp(id);
});
$main.find('#deleteEmp').live('click',function(){ 
	var id = $(this).attr('data-id');	 
	empTemp.eliminar(id); 
});
$main.find('#cancelEmp').live('click',function(){	
	empTemp.limpiarForm();
});

$main.find('#optDocRuc').live('click',function(){
	
		empTemp.rucCampos($(this));
		
});

$main.find('#optDocDni').live('click',function(){
	
		empTemp.dniCampos($(this));
	
});

empTemp = {
	init:function(){	
		$main.load(appName+'Empresa',function(e){	
			$('#page-wrapper').html(e);		
			empTemp.rucCampos();
			empTemp.getList();
		});				
	},
	getList:function(){
		$.get(appName+'listEmpresas',function(data){
		 $('#dataEmp').empty();
		 if(data!=null){
				for(var i=0;i<data.length;i++){
					var $tr = $('<tr class="item" />');					
					$tr.append('<td>'+data[i].id+'</td>');
					$tr.append('<td>'+data[i].dni+data[i].ruc+'</td>');
					$tr.append('<td>'+data[i].razonSocial+data[i].apellidos+' '+data[i].nombres+'</td>');
					$tr.append('<td>'+data[i].email+'</td>');
					$tr.append('<td>'+data[i].telefono+'</td>');
					$tr.append('<td><button id="editEmp" class="btn btn-warning" data-id="'+data[i].id+'">Editar</button>'+'&nbsp <button id="deleteEmp"  class="btn btn-danger" data-id="'+data[i].id+'">Eliminar</button></td>');
					$tr.data('data',data[i]);
				
					$('#dataEmp').append($tr);
				}
			}else{
				$('#info').html(showMsg("Error al mostrar la informacion"));
			}		   
		 },'json');	
	},	
	guardar:function(){		
		params={};
		
		if($('#optDocRuc').checked = true){
			params.ruc = $('#txtNroDoc').val();
			params.dni = '';
		}else{
			params.dni = $('#txtNroDoc').val();
			params.ruc = '';
		}
		
		params.id = $('#txtIdEmp').val();
		
		params.razonSocial = $('#txtRazonSocial').val();
		params.apellidos = $('#txtApellidos').val();
		params.nombres = $('#txtNombres').val();
		params.direccion = $('#txtDireccion').val();
		params.email = $('#txtEmail').val();
		params.telefono = $('#txtTelefono').val();
		params.observaciones = $('#txtObservs').val();
		
	    $.post(appName+'saveEmp',params,function(e){
	    	$('#info').html(showMsg(e));
	    	empTemp.getList();
	    	empTemp.limpiarForm();
	    });	   
	},
	getEmp:function(id){
		
		$.get(appName+'editEmp/'+id,function(data){			
			if(data!=null){			 
				$('#txtIdEmp').val(data.id);
				
				if(data.ruc == ''){					
					$('#txtNroDoc').val(data.dni);
					$('#optDocDni').prop('checked');
					empTemp.dniCampos();					
				}else{
					$('#txtNroDoc').val(data.ruc);
					empTemp.rucCampos();
				}
				
				$('#txtRazonSocial').val(data.razonSocial);
				$('#txtApellidos').val(data.apellidos);
				$('#txtNombres').val(data.nombres);
				$('#txtDireccion').val(data.direccion);
				$('#txtEmail').val(data.email);
				$('#txtTelefono').val(data.telefono);
				$('#txtObservs').val(data.observaciones);
			}else{
				$('#info').html(showMsg("Error al mostrar la informacion"));
			}		   
		 },'json');
	},
	eliminar:function(val){	
		 $conf = confirm("Desea eliminar este Item? ");	       
	       if($conf){
	    	   $.get(appName+'deleteEmp/'+val,function(e){
	    		   
	    		   $('#info').html(showMsg(e));
	    		   empTemp.getList();
		    	});
	       }else {
	    	   return false;
	       } 
	},
	limpiarForm:function(){		
		$('#txtIdEmp').val('');
		$('#txtNroDoc').val('');
		$('#txtRazonSocial').val('');
		$('#txtNroDoc').val('');
		$('#txtApellidos').val('');
		$('#txtNombres').val('');
		$('#txtDireccion').val('');
		$('#txtEmail').val('');
		$('#txtTelefono').val('');
		$('#txtObservs').val('');
	},
	rucCampos:function(val){
		$main.find('#optDocRuc').prop('checked','true');
		$('#txtRazonSocial').removeAttr('disabled');
		$('#txtApellidos').attr('disabled','true');
		$('#txtNombres').attr('disabled','true');
	},
	dniCampos:function(val){
		$main.find('#optDocDni').prop('checked','true');
		$('#txtRazonSocial').attr('disabled','true');
		$('#txtApellidos').removeAttr('disabled');
		$('#txtNombres').removeAttr('disabled');
	}
};