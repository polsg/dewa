<div id="page-inner">
	<div class="row">
		<div class="col-md-6">
			<h2>Modelador de Diagrama de Flujo</h2>
		</div>
	</div>
	<!-- /. ROW  -->
	<hr />
	<div class="row">
		<div class="col-md-3">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="form-group">
						<input class="form-control" type="hidden" id="txtIdProc" /> <br>
						
						<label>Nombre del Proceso</label> 
						<input class="form-control"	id="txtNombProceso" type="text" placeholder="Ejemplo: Mantenimiento de Motor"> <br>
						
						<label>Tipo de Proceso</label> 
						<select class="form-control" id="selTipoProceso">
					
						</select> <br> 
						
						<label>Responsable del Proceso</label> 
						<input class="form-control" type="text" id="txtResponable" placeholder="Ap. y Nombres"> <br> 
							<label>De la Empresa</label> 
							<input class="form-control" type="hidden" id="txtIdEmpresa" value="1" /> 
							<input class="form-control" type="text" id="txtNombEmpresa" placeholder="RUC o DNI" />
							<div id="nombEmpresa"></div>
						<br>
						 
						<label>Realizado por:</label> 
						<input class="form-control" type="hidden" id="txtIdPersonal" value="1" />
						<input class="form-control" type="text" id="txtNombPersonal" placeholder="DNI del Personal" />						
						<div id="nombPersonal"></div>
						
						<br> <label>Observaciones</label> 
						<input class="form-control" type="text" id="txtObservs" /> 
					</div>

				</div>


			</div>


		</div>


		<div class="col-md-9">
			

			<div class="row">
				<div class="col-md-12">
				<label>Lista de Tareas y/o Actividades</label>
				</div>
				<div class="col-md-12">					
					<div class="col-md-10">					
						<div id="listActividades">						
						</div>							
						<br>						
						<div class="alert alert-warning alert-dismissable">
							<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
							Para empezar, Click en el Boton "Agregar" para ingresar la descripcion de cada paso!
						</div>
						<div id="code"></div>
																							
					</div>
					<div class="col-md-2">					
						<div class="form-group">
							<input type="button" id="btnAddPasoCampo" class="btn btn-default" value="Agregar Pasos" />
							<input type="button" id="btnClearPasos"	class="btn btn-warning" value="Eliminar Pasos" />
							<input type="button" id="btnGenerar" class="btn btn-success" value="Ver Diagrama" />
							<input type="button" id="btnShowUml" class="btn btn-yellow" value="Ver Code Uml" />
							<!-- <input type="button" id="btnShow" class="btn btn-info" value="con" />-->
							<input type="button" id="saveProc" type="button" class="btn btn-primary" value="Guardar"> 
							<input type="button" id="btnCancel" type="button" class="btn btn-danger"	value="Cancelar">
							<input type="button" id="verPdf" type="button" class="btn btn-danger"	value="Pdf">
						</div>																			
					</div>																		
				</div>
				<div class="col-md-12">
					<div id="diagrama"></div>
					
				</div>
				<div class="col-md-12">
					<div id="pdf"></div>
					
				</div>
				
			</div>
			
			
		</div>
	</div>
</div>

