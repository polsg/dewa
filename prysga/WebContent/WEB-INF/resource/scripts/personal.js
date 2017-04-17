$main.find('#savePer').live('click',function(){
	perTemp.guardar()});
$main.find('#editPer').live('click',function(){
	perTemp.getListTC();
	 var id = $(this).attr('data-id');
	 
	 perTemp.getPer(id);
});

$main.find('#deletePer').live('click',function(){
	 var id = $(this).attr('data-id');
	 perTemp.eliminar(id);
});

$main.find('#cancelPer').live('click',function(){
	perTemp.limpiarForm();
});



perTemp = {
	init:function(){
	
		$main.load(appName+'Personal',function(e){	
			$('#page-wrapper').html(e);
			perTemp.getList();
			perTemp.getListTC();
		});				
	},
	getListTC:function(){			
		$.get(appName+'listTipoCargos',function(data){
			 $('#selTipoCargo').empty();
			 if(data!=null){
				 $('#selTipoCargo').append('<option value="">Seleccione una Opción</option>');
					for(var i=0;i<data.length;i++){
						var $option = $('');							
						$option = '<option value='+data[i].id+'>'+data[i].nombre+'</option>';				
											
						$('#selTipoCargo').append($option);
					}
				}else{
					$('#info').html(showMsg("Error al mostrar la informacion"));
				}		   
			 },'json');
	},
	getList:function(){
		$.get(appName+'listPersonal',function(data){
		 $('#dataPer').empty();
		 if(data!=null){
				for(var i=0;i<data.length;i++){
					var $tr = $('<tr class="item" />');					
					$tr.append('<td>'+data[i].id+'</td>');
					$tr.append('<td>'+data[i].nombreCargo+'</td>');
					$tr.append('<td>'+data[i].dni+'</td>');
					$tr.append('<td>'+data[i].apellidos+' '+data[i].nombres+'</td>');			
					$tr.append('<td><button id="editPer" class="btn btn-warning" data-id="'+data[i].id+'">Editar</button>'+'&nbsp <button id="deletePer"  class="btn btn-danger" data-id="'+data[i].id+'">Eliminar</button></td>');
					$tr.data('data',data[i]);
				
					$('#dataPer').append($tr);
				}
			}else{
				$('#info').html(showMsg("Error al mostrar la informacion"));
			}		   
		 },'json');	
	},	
	guardar:function(){		
		params={};    
		params.id = $('#txtIdPer').val();
		params.dni = $('#txtDni').val();
		params.apellidos = $('#txtApellidos').val();
		params.nombres = $('#txtNombrePer').val();
		params.idTipoCargo = $('#selTipoCargo').val();
		params.email = $('#txtEmail').val();
		params.claveUsuario = $('#txtClave').val();
		params.direccion = $('#txtDireccion').val();
		params.telefono = $('#txtTelefono').val();
		//params.imagen = $('#txtImagen').val();
		
		   
	    $.post(appName+'savePer',params,function(e){
	    	$('#info').html(showMsg(e));
	    	perTemp.getList();
	    	perTemp.limpiarForm();
	    });       
	   
	},
	getPer:function(id){
		
		$.get(appName+'editPer/'+id,function(data){
			
		 if(data!=null){			 
			//alert(data.idTipoCargo);
			//var dato = new Date(data.fechaNacimiento)
			$('#txtIdPer').val(data.id);
			$('#txtDni').val(data.dni);
			$('#txtApellidos').val(data.apellidos);
			$('#txtNombrePer').val(data.nombres);
			$('#selTipoCargo').val(data.idTipoCargo);
			$('#txtEmail').val(data.email);
			$('#txtClave').val(data.claveUsuario);
			$('#txtDireccion').val(data.direccion);
			$('#txtTelefono').val(data.telefono);
			//$('#txtImagen').val(data.imagen);
			}else{
				$('#info').html(showMsg("Error al mostrar la informacion"));
			}		   
		 },'json');
	},
	eliminar:function(val){
		
		 $confirmacion = confirm("Desea eliminar este Item? ");
	       
	       if($confirmacion){
	    	   $.get(appName+'deletePer/'+val,function(e){
	    		   $('#info').html(showMsg(e));
	    		   perTemp.getList();
		    	});
	       }else {
	    	   return false;
	       } 
	},
	limpiarForm:function(){
		$('#txtIdPer').val('');
		$('#txtDni').val('');
		$('#txtApellidos').val('');
		$('#txtNombrePer').val('');
		$('#selTipoCargo').val(0);
		$('#txtEmail').val('');
		$('#txtClave').val('');
		$('#txtDireccion').val('');
		$('#txtTelefono').val('');
		//$('#txtImagen').val('');
	}
};