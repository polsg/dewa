$('#btnIntro').live('click',function(){	
	uTemp.init()
});

$('#btnOut').live('click',function(){	
	uTemp.end()
});

$('#btnShowPerfil').live('click',function(){
	uTemp.verPerfil();
});

$main.find('#saveUser').live('click',function(){
	uTemp.guardar();
	uTemp.verPerfil();

});


uTemp = {
	conteo:0,
	verPerfil:function(){	
		$main.load(appName+'Usuario',function(e){	
			$('#page-wrapper').html(e);		
			perTemp.getListTC();	 	 
			uTemp.getUser();
		});				
	},
	init:function(){
		params ={}
		params.user = $('#usuario').val();
		params.pass =$('#clave').val();
		
		$.post(appName+'validarUser',params,function(e){
			var val =e.split(":");
			if(val[0] == "true"){
				location.href=val[1];
			}else{
				uTemp.conteo++;
				if(uTemp.conteo >= 3){
					alert()
					$('#mipanel').hide();
					$('#mipanel').show(300);
					$('#mipanel').html("Numero de intentos fallidos, consulte con su administrador");
				}else{
					alert("Error de usuario o contraseña");					
				}				
			}			
	    });		
	},
	end:function(){		
		alert("asd")
		$.post(appName+'logout',function(e){
			location.href=e;
		});		
	},
	getUser:function(){
		
		$.get(appName+'verUser',function(data){
			
		 if(data!=null){		
			 $('#txtEmail').attr('readonly','true');
			 $('#selTipoCargo').attr('disabled','true');
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
	    });	   
	}
}


