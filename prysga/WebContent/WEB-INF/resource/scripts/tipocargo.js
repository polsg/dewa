$main.find('#saveTC').live('click',function(){
	tcTemp.guardar()});
$main.find('#editTC').live('click',function(){
	 var id = $(this).attr('data-id');
	 tcTemp.getTC(id);
});

$main.find('#deleteTC').live('click',function(){
	 var id = $(this).attr('data-id');
	 tcTemp.eliminar(id);
});

$main.find('#cancelTC').live('click',function(){
	$('#txtIdTC').val();
	$('#txtNombreTC').val();
});


tcTemp = {
	init:function(){
		
		$main.load(appName+'TipoCargo',function(e){
			$('#page-wrapper').html(e);
			tcTemp.getList();
		});			
		 
		
	},
	getList:function(){
		$.get(appName+'listTipoCargos',function(data){
		 $('#dataTC').empty();
		 if(data!=null){
				for(var i=0;i<data.length;i++){
					var $tr = $('<tr class="item" />');					
					$tr.append('<td>'+data[i].id+'</td>');
					$tr.append('<td>'+data[i].nombre+'</td>');
					$tr.append('<td><a id="editTC"  class="btn btn-warning" href="javascript:void(0);" data-id="'+data[i].id+'">Editar</a>'+'&nbsp <a id="deleteTC"  class="btn btn-danger" href="javascript:void(0);" data-id="'+data[i].id+'">Eliminar</a></td>');
				
					$tr.data('data',data[i]);
				
					$('#dataTC').append($tr);
				}
			}else{
				$('#info').html(showMsg("Error al mostrar la informacion"));
			}		   
		 },'json');	
	},	
	guardar:function(){		
		params={};    
		params.id=$('#txtIdTC').val();
	    params.nombre=$('#txtNombreTC').val();
		   
	    $.post(appName+'saveTC',params,function(e){
	    	$('#info').html(showMsg(e));
	    	tcTemp.getList();
	    	$('#txtIdTC').val('');
	    	$('#txtNombreTC').val('');
	    });       
	   
	},
	getTC:function(id){
		$.get(appName+'editTC/'+id,function(data){
		
		 if(data!=null){			 
			 $('#txtIdTC').val(data.id);
			 $('#txtNombreTC').val(data.nombre);
			 
			}else{
				$('#info').html(showMsg("Error al mostrar la informacion"));
			}		   
		 },'json');
	},
	eliminar:function(val){
		
		 $confirmacion = confirm("Desea eliminar este Item? ");
	       
	       if($confirmacion){
	    	   $.get(appName+'deleteTC/'+val,function(e){
	    		   $('#info').html(showMsg(e));
		        	tcTemp.getList();
		    	});
	       }else {
	    	   return false;
	       } 
	}
};