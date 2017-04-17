<div id="page-inner">
	<div class="row">
		<div class="col-md-6">
			<h2>Tipo Cargo</h2>
		</div>
		<div id="msg" class="col-md-6"></div>
	</div>
	<!-- /. ROW  -->
	<hr />


	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<input class="form-control" type="hidden" id="txtIdTC" /> <label>Descripción</label>
				<input class="form-control" type="text" id="txtNombreTC" /> <br>
				<input id="saveTC" type="button" class="btn btn-primary"
					value="Guardar"> <input id="cancelTC" type="reset"
					class="btn btn-danger" value="Cancelar">
			</div>
			<div id="info"></div>
		</div>
		<div class="col-md-8">
			<label>Lista de Tipos de Cargo</label>
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Descripción</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody id="dataTC">
				</tbody>
			</table>

		</div>
	</div>
</div>