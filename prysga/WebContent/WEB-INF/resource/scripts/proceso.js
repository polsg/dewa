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
	procTemp.condicion=0;
	procTemp.strCondi=[];
	$('#listActividades').empty();
	procTemp.agregarPaso();
	$('#btnAddPasoCampo').attr('enabled','true');
});

$main.find('#btnGenerar').live('click',function(){
	procTemp.showDiagram();
});


$main.find('#block').live('click',function(){
	$(this).hide();
});

$main.find('#btnShowUml').live('click',function(){
	procTemp.umlShow();
})
$main.find('#btnShow').live('click',function(){
	procTemp.uo();
})

$main.find('#saveProc').live('click',function(){
	procTemp.saveData();
})



$main.find('#btnSearch').live('click',function(){
	procTemp.getListProcesBy();
})



$main.find('#btnPdf').live('click',function(){
	procTemp.verPdf();
})

$main.find('#verPdf').live('click',function(){
	var idProc = $(this).attr('data-id');
	procTemp.verPdfProc(idProc);
})
$('#btnCerrarPdf').live('click',function(){
	procTemp.closePopup();
})

procTemp = {
	campo:1,
	cadenaUml:"",
	sigPaso:null,
	strCondi:[],
	condicion:0,	
	init:function(){	
		$main.load(appName+'gestProceso',function(e){	
			$('#page-wrapper').html(e);
			procTemp.getListProces();
			procTemp.getListTP();
		});				
	},
	getListProcesBy:function(){	
		params={};
		params.empresa = $('#txtEmpresa').val();
		params.proceso = $('#txtProceso').val();
		params.tiproce = $('#selTipoProceso').val();
		params.fecini = $('#txtFecIni').val();
		params.fecfin = $('#txtFecFin').val();
		
		//alert(params.empresa)
		$.post(appName+'listProcesosBy',params,function(data){
			 $('#dataProc').empty();	
			 if(data!=null){				 
				 for(var i=0;i<data.length;i++){
						var $tr = $('<tr class="item" />');					
						$tr.append('<td>'+data[i].id+'</td>');
						$tr.append('<td>'+data[i].nombEmpresa+'</td>');
						$tr.append('<td>'+data[i].nombreProceso+'</td>');
						$tr.append('<td>'+data[i].nombTipoProceso+'</td>');
						$tr.append('<td>'+data[i].nombResponsable+'</td>');
						$tr.append('<td>'+data[i].nombPersonal+'</td>');
						$tr.append('<td>'+data[i].fechaRegistro+'</td>');
						$tr.append('<td>   <button id="verPdf" class="btn btn-danger" data-id="'+data[i].id+'"><i class="fa fa-copy"></i></button>'+
								'&nbsp <button id="checkProc"  class="btn btn-info" data-id="'+data[i].id+'"><i class="fa fa-picture-o"></i></button>'+
								'</td>');
						$tr.data('data',data[i]);
					
						$('#dataProc').append($tr);
					}
				}else{
					$('#info').html(showMsg("Error al mostrar la informacion"));
				}		   
			 },'json');
	},

	agregarPaso:function(){
		$('#step'+(procTemp.campo)).attr('readonly','true');
		procTemp.campo++;		
		$('#listActividades').append('<div id="estado'+procTemp.campo+'" > Paso '+procTemp.campo+': <input id="step'+procTemp.campo+'" name="step" class="form-control" type="text"></div>');
		$('#step'+(procTemp.campo)).focus();
	},	
	agregarPasoCond:function(){
		$('#step'+(procTemp.campo)).attr('readonly','true');
		procTemp.campo++;		
		$('#listActividades').append('<div id="estado'+procTemp.campo+'" > Paso '+procTemp.campo+': <input id="step'+procTemp.campo+'" name="step" class="form-control" type="text" value="Sino" ></div>');
	},
	finProceso:function(){
		$('#step'+(procTemp.campo)).attr('readonly','true');		
		$('#btnAddPasoCampo').attr('disabled','true');
	},
	initCond:function(){		
		procTemp.strCondi.push(procTemp.campo);
		 $('#estado'+(procTemp.campo)).attr('class','form-group has-warning');
		 $('#step'+(procTemp.campo)).attr('title','Esta sentencia no tiene la condicional finalizada!..');
	},
	endCond:function(){	
		alert(procTemp.strCondi[procTemp.strCondi.length-1])
		 $('#estado'+(procTemp.strCondi[procTemp.strCondi.length-1])).attr('class','form-group has-success');
		 $('#step'+(procTemp.strCondi[procTemp.strCondi.length-1])).attr('title','Condicional finalizada!..');
		 procTemp.strCondi.pop();
	},
	model:function(){	
		procTemp.campo = 1;
		$main.load(appName+'Modelador',function(e){	
			$('#page-wrapper').html(e);
			$('#listActividades').append('<div id="estado'+procTemp.campo+'" > Paso '+procTemp.campo+': <input id="step'+procTemp.campo+'" name="step" class="form-control" type="text"></div>');
			procTemp.getListTP();
		});				
	},	
	getListProces:function(){			
		$.get(appName+'listProcesos',function(data){
			 $('#dataProc').empty();	
			 if(data!=null){				 
				 for(var i=0;i<data.length;i++){
						var $tr = $('<tr class="item" />');					
						$tr.append('<td>'+data[i].id+'</td>');
						$tr.append('<td>'+data[i].nombEmpresa+'</td>');
						$tr.append('<td>'+data[i].nombreProceso+'</td>');
						$tr.append('<td>'+data[i].nombTipoProceso+'</td>');
						$tr.append('<td>'+data[i].nombResponsable+'</td>');
						$tr.append('<td>'+data[i].nombPersonal+'</td>');
						$tr.append('<td>'+data[i].fechaRegistro+'</td>');
						$tr.append('<td>   <button id="verPdf" class="btn btn-danger" data-id="'+data[i].id+'"><i class="fa fa-copy"></i></button>'+
									'&nbsp <button id="checkProc"  class="btn btn-info" data-id="'+data[i].id+'"><i class="fa fa-picture-o"></i></button>'+
									'</td>');
						$tr.data('data',data[i]);
					
						$('#dataProc').append($tr);
					}
				}else{
					$('#info').html(showMsg("Error al mostrar la informacion"));
				}		   
			 },'json');
	},
	getListTP:function(){			
		$.get(appName+'listTipoProcesos',function(data){
			 $('#selTipoProceso').empty();
			 if(data!=null){
				 $('#selTipoProceso').append('<option value="">Seleccionar opcion</option>');
					for(var i=0;i<data.length;i++){
						var $option = $('');							
						$option = '<option value='+data[i].id+'>'+data[i].nombre+'</option>';										
						$('#selTipoProceso').append($option);					}
				}else{
					$('#info').html(showMsg("Error al mostrar la informacion"));
				}		   
			 },'json');
	},
	saveData:function(){
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
		params.codeUml = procTemp.cadenaUml;
		
		$.post(appName+'saveProc',params,function(e){
			
			$('#info').html(showMsg(e));
			
		});	
		 
	},
	setTokens:function(){
		var valuesText = "";
		var verdad=true;
		params ={};
		
		/*$('input[name=step]').each(function(){ valuesText += $(this).val() +','; });
		params.actividad = valuesText.substring(0,valuesText.length -1);*/
		
		params.actividad = procTemp.campo+'>'+$('#step'+(procTemp.campo)).val()
		
		if($('#step'+(procTemp.campo)).val().substr(0,2).toUpperCase()=='SI' && procTemp.campo==1)
		{
			alert('No se puede iniciar una condicion en el primer paso')
		}
		else
		{	
			$.post(appName+'analizarTexto',params,function(data){		
			var texto = $('#step'+(procTemp.campo)).val();
			var pal=texto.split(" ");
			//alert(pal[0]);
				if(data.estado == 'true'){	
					alert(data.mensaje)	
					if(pal[0].trim().toUpperCase()=='SI')
					{
						//alert (data.condicion+"\n"+data.sujeto+"\n"+data.predicado);
						procTemp.condicion++;
						procTemp.cadenaUml+=procTemp.umlCond(data)
						$cond = confirm("Dese Finalizar la Oracion Condicional?");
						 if($cond){
							 procTemp.cadenaUml += "\n endif \n";	
							 procTemp.endCond();
							 $confirmar = confirm("Dese Finalizar el Proceso?");
							 if($confirmar){
								 procTemp.cadenaUml += "\n stop \n";
								 procTemp.finProceso();								 
							 }
							 else
							 {
								 procTemp.agregarPaso();									
							 }								 
						 }
						 else
						 {
							 procTemp.initCond();
							 procTemp.agregarPasoCond();
						 }
					}
					else if(pal[0].trim().toUpperCase()=='SINO')
					{
						procTemp.cadenaUml +=procTemp.umlCondSino(data)
						$cond = confirm("Dese Finalizar la Oracion Condicional?");
						 if($cond){
							 procTemp.condicion--;
							 procTemp.cadenaUml += "endif\n";
							 procTemp.endCond();
							 $confirmar = confirm("Dese Finalizar el Proceso?");
							 if($confirmar){
								 procTemp.cadenaUml += "stop\n";
								 procTemp.finProceso();								 
							 }
							 else
							 {
								 procTemp.agregarPaso();									
							 }								 
						 }
						 else
						 {
							 procTemp.agregarPasoCond();							 
						 }
					}
					else
					{
						if(procTemp.condicion==0)
						{
							procTemp.cadenaUml += procTemp.umlOraSimple(data); 						
							$confirmar = confirm("Dese Finalizar el Proceso?");
							 if($confirmar){
								 procTemp.cadenaUml += "stop\n";
								 procTemp.finProceso();
								 
							 }else{
								 procTemp.agregarPaso();							
							 }							
						}
						else
						{
							procTemp.cadenaUml += procTemp.umlOraSimple(data); 						
							$cond = confirm("Dese Finalizar la Oracion Condicional?");
							 if($cond){
								 procTemp.condicion--;
								 procTemp.cadenaUml += "endif\n";
								 procTemp.endCond();
								 $confirmar = confirm("Dese Finalizar el Proceso?");
								 if($confirmar){
									 procTemp.cadenaUml += "stop\n";
									 procTemp.finProceso();								 
								 }
								 else
								 {
									 procTemp.agregarPaso();									
								 }								 
							 }
							 else
							 {
								 procTemp.agregarPasoCond();							 
							 }
						}						
					}
					alert(procTemp.cadenaUml)
				}
				else
				{
					alert(data.mensaje)
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
	umlOraSimple: function(val){
	
		if(procTemp.campo!=1)
		{			
			return "|"+val.sujeto+"|\n:"+val.predicado+";\n";
		}
		else
		{			
			return "|"+val.sujeto+"|\nstart\n:"+val.predicado+";\n";
		}
		
	},	
	umlCond: function(val){
		return "if ("+val.condicion+") then (yes)\n "+procTemp.umlOraSimple(val);
	},
	umlCondSino: function(val){
		return "else (no) \n"+procTemp.umlOraSimple(val);		
	},
	umlShow: function(){
		if(procTemp.cadenaUml!=""){
			return $main.find('#code').html('<pre>'+procTemp.cadenaUml+'</pre>');
		}else{
			return $main.find('#code').html('<pre> No exite Codigo UML </pre>');
		}
	},
	uo: function(){		
		alert(procTemp.strCondi.length+" "+procTemp.campo)
		for (var i = 0; i < procTemp.strCondi.length; i++) {
			alert(procTemp.strCondi[i])
		}
	}
	,
	verPdf: function(){		
		window.open("http://localhost:8080/prysga/downloadPDF","Lista de Procesos", "width=1200, height=1100");
	},
	verPdfProc:function(val){
		$('#popupbox').show();
		$('#popupbox').html('<iframe id="pdf" src="http://localhost:8080/prysga/verPdf/'+val+'" width="1000" height="500"></iframe><br><button id="btnCerrarPdf" class="btn btn-danger">Cerrar</button>');
		//window.open('http://localhost:8080/prysga/verPdf/'+val,'Proceso', 'width=1200', 'height=1100')
		
	},
	closePopup: function(){		
		$('#popupbox').hide();
	}
	
}
