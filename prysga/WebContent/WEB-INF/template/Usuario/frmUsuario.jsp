<div id="page-inner">
	<div class="row">
		<div class="col-md-6">
			<h2>Bievenido ${hola}</h2>
		</div>
	</div>
	<!-- /. ROW  -->
	<hr />
	<div class="row">
		<div class="col-md-12">

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
				<input id="saveUser" type="button" class="btn btn-primary"	value="Guardar"> 
					<input id="cancelPer" type="button"class="btn btn-danger" value="Cancelar">
			</form>
		</div>

	</div>
</div>

