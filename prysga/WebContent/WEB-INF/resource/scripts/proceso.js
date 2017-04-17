$main.find('#btnAddPasoCampo').live('click',function(){
	if(validarCampo($('#step'+(procTemp.campo)).val())){
		procTemp.setTokens()	
	}else{
		alert("Tiene el Paso "+procTemp.campo+" vacio")
	}	
});

$main.find('#btnClearPasos').live('click',function(){
	procTemp.campo = 0;
	procTemp.cadenaUml="",
	$('#listActividades').empty();
	procTemp.agregarPaso();
});

$main.find('#btnGenerar').live('click',function(){
	procTemp.showDiagram();
});


$main.find('#block').live('click',function(){
	$(this).hide();
})

procTemp = {
	campo:1,
	cadenaUml:"",
	sigPaso:null,
	stringCondi:"",
	condicion:{},
	agregarPaso:function(){
		$('#step'+(procTemp.campo)).attr('disabled','true');
		procTemp.campo++;		
		$('#listActividades').append('Paso '+procTemp.campo+': <input id="step'+procTemp.campo+'" name="step" class="form-control" type="text">');
	},
	init:function(){	
		$main.load(appName+'Proceso',function(e){	
			$('#page-wrapper').html(e);
		});				
	},
	model:function(){	
		procTemp.campo = 1;
		$main.load(appName+'Modelador',function(e){	
			$('#page-wrapper').html(e);
			$('#listActividades').append('Paso '+procTemp.campo+': <input id="step'+procTemp.campo+'" name="step" class="form-control" type="text">');
			procTemp.getListTP();
		});				
	},	
	getListTP:function(){			
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
	},
	procesarData:function(){
		var valuesText = "";		
		params = {};			
		$('input[name=step]').each(function(){ valuesText += $(this).val() +','; });
		
	    params.id = $("#txtIdProc").val();
		params.idPersonal = $("#txtIdPersonal").val(); 
		params.idEmpresa = $("#txtIdEmpresa").val();
		params.idTipoProceso = $("#selTipoProceso").val();
		params.nombreProceso = $("#txtNombProceso").val();
		params.nombResponsable = $("#txtResponable").val();
		params.descActividades = valuesText.substring(0,valuesText.length -1);
		params.observaciones = $("#txtObservs").val();
		 
	},
	setTokens:function(){
		var valuesText = "";
		var verdad=true;
		params ={};
		/*$('input[name=step]').each(function(){ valuesText += $(this).val() +','; });
		params.actividad = valuesText.substring(0,valuesText.length -1);*/
		params.actividad = procTemp.campo+'>'+$('#step'+(procTemp.campo)).val()
		
		if($('#step'+(procTemp.campo)).val().substr(0,2).toUpperCase()=='SI' && procTemp.campo==1){
			alert('No se puede iniciar una condicion en el primer paso')
		}else{
	
		$.post(appName+'setTokens',params,function(data){
			
			var dataString = data.split(">");
			if(dataString[0].trim()=='true'){
				procTemp.cadenaUml= procTemp.cadenaUml+dataString[1].trim()+" \n "; 
				alert(procTemp.cadenaUml)
				$confirmar = confirm("Dese Finalizar el Proceso?");
				 if($confirmar){
					 procTemp.cadenaUml += "\n stop \n";
					 procTemp.sigPaso=false;
				 }else{
					 procTemp.agregarPaso();
					 procTemp.sigPaso=true;
				 }
				 
			}else{
				alert('Error en la oracion: no se tiene el verbo indicado')
			}			
        });
		}
		return verdad;
		
	},	
	showDiagram:function(){
		$('#diagrama').load(appName+'Diagram',function(e){	
			 $(this).html(e);	
			 $(this).html('<br><img uml="'+procTemp.cadenaUml+'">');	            
		});
	},		
}
