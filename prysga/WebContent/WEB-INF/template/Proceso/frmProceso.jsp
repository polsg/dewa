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
				<div class="col-md-3">
					<div class="form-group">
						<select class="form-control">
							<option value="#">Relevancia</option>
							<option value="1">Apellidos y/o Nombres</option>
							<option value="2">Razón Social</option>
							<option value="3">DNI/RUC</option>
						</select>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<input class="form-control" type="text"
							placeholder="Ingresar una descripcion">

					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<input type="button" class="btn btn-primary" value="BuscarEmp" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<label>Lista de Empresas</label>

					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>Item</th>
								<th>Nro. Documento</th>
								<th>Nombres o Razón Social</th>
								<th>Correo Electronico</th>
								<th>Telefono</th>
								<th>Acciones</th>
							</tr>
						</thead>
						<tbody id="dataEmp">
						</tbody>
					</table>

				</div>
			</div>
		</div>
	</div>
</div>

