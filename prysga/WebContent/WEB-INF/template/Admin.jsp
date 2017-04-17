<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Prysga Project III</title>
<!-- BOOTSTRAP STYLES-->
<link href="resource/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="resource/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="resource/css/custom.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="resource/css/jquery.datepick.css" rel="stylesheet" />

<!-- GOOGLE FONTS-->

<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
<!-- JQUERY SCRIPTS -->
	

	
</head>
<body>
	<div id="block"></div>
	<div id="popupbox"></div>
	<div id="wrapper">
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="adjust-nav">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".sidebar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="javascript:void(0);"><i
						class="fa fa-coffee "></i>&nbsp;Prysga Proyect III</a>
				</div>



				<ul class="nav navbar-top-links navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="javascript:void(0);"> <i
							class="fa fa-user fa-2x"></i> Pol SG
					</a> <!-- dropdown user-->
						<ul class="dropdown-menu dropdown-user">
							<li><a href="javascript:void(0);"><i
									class="fa fa-user fa-fw"></i>Perfil de Usuario</a></li>
							<li class="divider"></li>
							<li><a href="/test/"><i class="fa fa-sign-out fa-fw"></i>Cerrar
									Sesion</a></li>
						</ul> <!-- end dropdown-user --></li>
				</ul>

			</div>
		</div>
		<!-- /. NAV TOP  -->
		<div class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li class="text-center"><img
						src="resource/img/bs_header1.jpg" class="img-responsive" /></li>
					<li><a href="javascript:void(0);"><i class="fa fa-sitemap"></i>Proceso<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a id="idModelador" href="javascript:void(0);"><i
									class="fa fa-spinner"></i>Modelador</a></li>
							<li><a id="idProceso" href="javascript:void(0);"><i
									class="fa fa-spinner"></i>Gestión de proceso</a></li>
							<li><a id="idTipoProceso" href="javascript:void(0);"><i
									class="fa fa-edit"></i>Tipo de Proceso</a></li>
						</ul></li>
					<li><a href="javascript:void(0);"><i class="fa fa-qrcode "></i>Empresas<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a id="idEmpresas" href="javascript:void(0);"><i
									class="fa fa-table"></i>Listado</a></li>
						</ul></li>
					<li><a href="javascript:void(0);"><i
							class="fa fa-folder-o "></i>Personal<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a id="idPersonal" href="javascript:void(0);"><i
									class="fa fa-table"></i>Listado</a></li>
							<li><a id="idTipoCargo" href="javascript:void(0);"><i
									class="fa fa-edit"></i>Tipo de Cargo</a></li>
						</ul></li>

					<!--    <li>
                        <a href="javascript:void(0);"><i class="fa fa-clipboard"></i>Reportes<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a id="idReporteProceso" href="javascript:void(0);"><i class="fa fa-bar-chart-o"></i>Procesos</a>
                            </li>

                            <li>
                                <a id="idReportePersonal" href="javascript:void(0);"><i class="fa fa-bar-chart-o "></i>Personal</a>
                            </li>
                            <li>
                                <a id="idReporteEmpresas" href="javascript:void(0);"><i class="fa fa-bar-chart-o "></i>Empresas</a>
                            </li>
                        </ul>
                    </li>     -->
				</ul>
			</div>
		</div>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">

			<div id="page-inner">

				<div class="row">
					<div class="col-md-12">
						<h2>Bienvenido a Modelador 1.1</h2>
					</div>
					<div class="col-lg-12"></div>
				</div>
				<!-- /. ROW  -->
				<hr />

				<!-- /. ROW  -->
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->

	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="resource/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="resource/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="resource/js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="resource/js/custom.js"></script>

<script src="resource/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="resource/js/jquery.plugin.js"></script>
	<script type="text/javascript" src="resource/js/jquery.datepick.js"></script>
	

	<script type="text/javascript" src="resource/scripts/template.js"></script>

	<script type="text/javascript" src="resource/scripts/proceso.js"></script>
	<script type="text/javascript" src="resource/scripts/tipocargo.js"></script>
	<script type="text/javascript" src="resource/scripts/tipoproceso.js"></script>
	<script type="text/javascript" src="resource/scripts/personal.js"></script>
	<script type="text/javascript" src="resource/scripts/empresa.js"></script>


</body>
</html>