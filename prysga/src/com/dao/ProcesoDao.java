package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.interfaces.ProcesoInterfaz;
import com.model.Proceso;
import com.utilities.Variable;

public class ProcesoDao implements ProcesoInterfaz{

	private JdbcTemplate template;
	private Variable dato;
	
	ProcesoDao(){
		dato = new Variable();
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}	
	
	@Override
	public List<Proceso> getAllProcesos() {
		// TODO Auto-generated method stub
		String sql="SELECT proc.*,concat(per.apellidos,' ', per.nombres) AS 'nombPersonal',concat(emp.razonSocial,emp.apellidos,emp.nombres) AS 'nombEmpresa',tc.nombre AS 'nombTipoProceso' FROM procesos AS proc "+
						"INNER JOIN personal AS per ON proc.idPersonal = per.id "+
						"INNER JOIN empresas AS emp ON proc.idEmpresa = emp.id "+
						"INNER JOIN tipoprocesos AS tc ON proc.idTipoproceso = tc.id "+
						"WHERE proc.estado = 1";
		return template.query(sql, new RowMapper<Proceso>(){
			public Proceso mapRow(ResultSet rs, int row) throws SQLException{
				Proceso proc = new Proceso();
				proc.setId(rs.getInt("id"));
				proc.setIdEmpresa(rs.getInt("idEmpresa"));
				proc.setNombEmpresa(rs.getString("nombEmpresa"));
				proc.setIdPersonal(rs.getInt("idPersonal"));
				proc.setNombPersonal(rs.getString("nombPersonal"));
				proc.setIdTipoProceso(rs.getInt("idTipoProceso"));
				proc.setNombTipoProceso(rs.getString("nombTipoProceso"));
				proc.setNombProceso(rs.getString("nombProceso"));
				proc.setNombreResponsable(rs.getString("nombResponsable"));
				proc.setDescActividades(rs.getString("descActividades"));
				proc.setObservaciones(rs.getString("observaciones"));				
				return proc;
			}
		});
	}

	@Override
	public Proceso getProcesoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addProceso(Proceso pro) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProceso(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateProceso(Proceso pro) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
