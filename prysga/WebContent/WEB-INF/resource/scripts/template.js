var $n = $('#main-menu');
var $main = $('#page-wrapper');
var appName = '/prysga/';

$main.load(appName+'Modelador',function(e){	
	$('#page-wrapper').html(e);
	$('#listActividades').append('Paso 1: <input id="step1" name="step" class="form-control" autofocus type="text">');
	getListTP();
});	
$n.find('#idIntro').click(function(){procTemp.model();});
$n.find('#idModelador').click(function(){procTemp.model();});
$n.find('#idProceso').click(function(){procTemp.init();});
$n.find('#idTipoProceso').click(function(){tpTemp.init();});
$n.find('#idEmpresas').click(function(){empTemp.init();});
$n.find('#idPersonal').click(function(){perTemp.init();});
$n.find('#idTipoCargo').click(function(){tcTemp.init();});

showMsg = function(mensaje){ 
	return  '<div class="alert alert-success alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>'+mensaje+'</div>'; 
}

validarCampo = function(val){
	if( val == null || val.length == 0 || /^\s+$/.test(val) ) {
		return false;
	}else{
		return true;
	}
}


getListTP=function(){			
	$.get(appName+'listTipoProcesos',function(data){
		 $('#selTipoProceso').empty();
		 if(data!=null){
			 $('#selTipoProceso').append('<option value="">Seleccione una Opción</option>');
				for(var i=0;i<data.length;i++){
					var $option = $('');							
					$option = '<option value='+data[i].id+'>'+data[i].nombre+'</option>';				
										
					$('#selTipoProceso').append($option);
				}
			}else{
				$('#info').html(showMsg("Error al mostrar la informacion"));
			}		   
		 },'json');
}

