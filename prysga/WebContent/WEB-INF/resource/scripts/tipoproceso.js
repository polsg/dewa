$main.find('#saveTP').live('click',function(){tpTemp.guardar()});
$main.find('#editTP').live('click',function(){
	 var id = $(this).attr('data-id');
	 tpTemp.getTP(id);
});

$main.find('#deleteTP').live('click',function(){
	 var id = $(this).attr('data-id');
	 tpTemp.eliminar(id);
});

$main.find('#cancel').live('click',function(){
	$('#txtIdTP').val('');
	$('#txtNombreTP').val('');
});


tpTemp = {
	init:function(){
		
		$main.load(appName+'TipoProceso',function(e){
			$('#page-wrapper').html(e);
			tpTemp.getList();
		});			
		 
		
	},
	getList:function(){
		$.get(appName+'listTipoProcesos',function(data){
		 $('#dataTP').empty();
		 if(data!=null){
				for(var i=0;i<data.length;i++){
					var $tr = $('<tr class="item" />');					
					$tr.append('<td>'+data[i].id+'</td>');
					$tr.append('<td>'+data[i].nombre+'</td>');
					$tr.append('<td><a id="editTP"  class="btn btn-warning" href="javascript:void(0);" data-id="'+data[i].id+'">Editar</a>'+'&nbsp <a id="deleteTP"  class="btn btn-danger" href="javascript:void(0);" data-id="'+data[i].id+'">Eliminar</a></td>');
				
					$tr.data('data',data[i]);
				
					$('#dataTP').append($tr);
				}
			}else{
				$('#info').html(showMsg("Error al mostrar la informacion"));
			}		   
		 },'json');	
	},	
	guardar:function(){		
		params={};    
		params.id=$('#txtIdTP').val();
	    params.nombre=$('#txtNombreTP').val();
		   
	    $.post(appName+'saveTP',params,function(e){
	    	$('#info').html(showMsg(e));
	    	tpTemp.getList();
	    	$('#txtIdTP').val('');
	    	$('#txtNombreTP').val('');
	    });       
	   
	},
	getTP:function(id){
		$.get(appName+'editTP/'+id,function(data){
		
		 if(data!=null){			 
			 $('#txtIdTP').val(data.id);
			 $('#txtNombreTP').val(data.nombre);
			 
			}else{
				$('#info').html(showMsg("Error al mostrar la informacion"));
			}		   
		 },'json');
	},
	eliminar:function(val){
		
		 $confirmacion = confirm("Desea eliminar este Item? ");
	       
	       if($confirmacion){
	    	   $.get(appName+'deleteTP/'+val,function(e){
	    		   $('#info').html(showMsg(e));
		        	tpTemp.getList();
		    	});
	       }else {
	    	   return false;
	       } 
	}
};