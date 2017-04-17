<!DOCTYPE html>
<html lang="es" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Acceder al Sistema</title>
<!-- BOOTSTRAP STYLES-->
<link href="resource/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="resource/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="resource/css/custom.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="resource/css/style.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
</head>
<body>
	<div id="block"></div>
	<div id="popupbox"></div>
	<div class="container">
		<div style="padding: 8em 1em">
			<div class="row">

				<div class="col-md-8 text-center" style="padding: 2em 1em">
					<img src="resource/img/bs_header2.jpg">
				</div>
				<div id="mipanel" class="col-md-4 ">
					<h2 class="text-center">Bienvenido</h2>
					<div class="login-panel panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Login</h3>
						</div>
						<div class="panel-body">


							<div class="form-group">
								<input class="form-control" placeholder="Nombre de Usuario"
									id="txtNombreUser">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Clave" id="txtClave"
									type="password">
							</div>
							<div class="checkbox">
								<input type="checkbox" value="false" name="remenber"> No
								Cerrar Sesion
							</div>

							<input type="button" class="btn btn-lg btn-success btn-block"
								id="btnEntrar" value="Entrar">

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="resource/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="resource/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="resource/js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="resource/js/custom.js"></script>
	<!-- JQUERY SCRIPTS -->
	<script src="resource/js/jquery-2.1.1.js"></script>
	<!-- JQUERY SCRIPTS -->
	<script src="resource/scripts/usuario.js"></script>

</body>
</html>