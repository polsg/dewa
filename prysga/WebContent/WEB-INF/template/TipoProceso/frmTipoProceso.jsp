<div id="page-inner">
	<div class="row">
		<div class="col-md-6">
			<h2>Tipo Proceso</h2>
		</div>
		<div id="msg" class="col-md-6"></div>
	</div>
	<!-- /. ROW  -->
	<hr />


	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<input class="form-control" type="hidden" id="txtIdTP" /> <label>Descripción</label>
				<input class="form-control" type="text" id="txtNombreTP" /> <br>
				<input id="saveTP" type="button" class="btn btn-primary"
					value="Guardar"> <input id="cancelTP" type="reset"
					class="btn btn-danger" value="Cancelar">
			</div>
			<div id="info"></div>
		</div>
		<div class="col-md-8">
			<label>Lista de Tipos de Procesos</label>
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Descripción</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody id="dataTP">
				</tbody>
			</table>

		</div>
	</div>
</div>