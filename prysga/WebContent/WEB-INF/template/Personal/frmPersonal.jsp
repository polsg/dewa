<div id="page-inner">
	<div class="row">
		<div class="col-md-6">
			<h2>Personal</h2>
		</div>
	</div>
	<!-- /. ROW  -->
	<hr />
	<div class="row">
		<div class="col-md-3">

			<form>
				<div class="form-group">
					<input class="form-control" type="hidden" id="txtIdPer" /> <label>DNI</label>
					<input class="form-control" type="text" id="txtDni" /> <br> <label>Apellidos</label>
					<input class="form-control" type="text" id="txtApellidos" /> <br>
					<label>Nombres</label> <input class="form-control" type="text"
						id="txtNombrePer" /> <br> <label>Tipo Cargo</label> <select
						class="form-control" id="selTipoCargo">
						<option value="0">Seleccionar una Opción</option>
					</select> <br> <label>Correo Electronico</label> <input
						class="form-control" type="text" id="txtEmail" /> <br> <label>Contraseña</label>
					<input class="form-control" type="password" id="txtClave" /> <br>
					<label>Dirección</label> <input class="form-control" type="text"
						id="txtDireccion" /> <br> <label>Telefono</label> <input
						class="form-control" type="text" id="txtTelefono" /> <br>
					<!--<label>Imagen</label>-->
					<input class="form-control" type="hidden" id="txtImagen"
						value="imagenSS" />

				</div>
				<input id="savePer" type="button" class="btn btn-primary"
					value="Guardar"> <input id="cancelPer" type="button"
					data-dismiss="modal" class="btn btn-danger" value="Cancelar">
			</form>
		</div>


		<div class="col-md-9">
			<div class="row">


				<div class="col-md-3">
					<div class="form-group">
						<select class="form-control">
							<option value="#">Relevancia</option>
							<option value="1">Apellidos y/o Nombres</option>
							<option value="2">DNI</option>
							<option value="3">Cargo</option>
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
						<input type="button" class="btn btn-primary" value="Buscar" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<label>Lista del Personal</label>

					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>Item</th>
								<th>Cargo</th>
								<th>DNI</th>
								<th>Apellidos y Nombres</th>
								<th>Acciones</th>
							</tr>
						</thead>
						<tbody id="dataPer">
						</tbody>
					</table>

				</div>
			</div>
		</div>
	</div>
</div>

