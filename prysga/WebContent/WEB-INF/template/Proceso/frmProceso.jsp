<div id="page-inner">
	<div class="row">
		<div class="col-md-6">
			<h2>Procesos</h2>
		</div>
	</div>
	<!-- /. ROW  -->
	<hr />
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">					
					<label>Empresa</label> 
					<input class="form-control" type="text" id="txtEmpresa"	placeholder="Descripción">	
				</div>
				<div class="col-md-2">					
					<label>Proceso</label> 
					<input class="form-control" type="text"	id="txtProceso" placeholder="Nombre">	
				</div>
				<div class="col-md-2">					
						<label>Tipo de Proceso</label> 
						<select class="form-control" id="selTipoProceso">
							
						</select> <br> 
				</div>
				<div class="col-md-2">					
					<label>Fecha Inicial</label> 
					<input class="form-control" type="text" id="txtFecIni" >	
				</div>
				<div class="col-md-2">					
					<label>Fecha Final</label> 
					<input class="form-control" type="text"	id="txtFecFin">	
				</div>
				<div class="col-md-2">			
					 <button class="btn btn-info "  id="btnSearch">Buscar</button>
				</div>
				<div class="col-md-2">			
					 <button class="btn btn-danger "  id="btnPdf">Exportar Pdf</button>
				</div>
				
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<label>Lista de Empresas</label>

					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>Item</th>
								<th>Nombres o Razón Social</th>
								<th>Nombre del Proceso</th>
								<th>Tipo Proceso</th>
								<th>Encargado del Proceso</th>
								<th>Usuario</th>
								<th>Fecha Registro</th>
								<th>Acciones</th>
							</tr>
						</thead>
						<tbody id="dataProc">
						</tbody>
					</table>

				</div>
			</div>
			
			
			<div class="row">
	<!-- 		<iframe id="pdf" src="http://localhost:8080/prysga/verPdf/3" width="200" height="200"></iframe> -->
				
			</div>
		</div>
	</div>
</div>

