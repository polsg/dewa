package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.interfaces.ProcesoInterfaz;
import com.model.Personal;
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
		String sql="SELECT proc.*,concat(per.email) AS 'nombPersonal',concat(emp.razonSocial,emp.apellidos,emp.nombres) AS 'nombEmpresa',tc.nombre AS 'nombTipoProceso' FROM procesos AS proc "+
						"INNER JOIN personal AS per ON proc.idPersonal = per.id "+
						"INNER JOIN empresas AS emp ON proc.idEmpresa = emp.id "+
						"INNER JOIN tipoprocesos AS tc ON proc.idTipoproceso = tc.id "+
						"WHERE proc.estado = 1 ORDER BY proc.id DESC";
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
				proc.setNombreProceso(rs.getString("nombreProceso"));
				proc.setNombResponsable(rs.getString("nombResponsable"));
				proc.setDescActividades(rs.getString("descActividades"));
				proc.setCodeUml(rs.getString("codeUml"));
				proc.setObservaciones(rs.getString("observaciones"));
				proc.setFechaRegistro(rs.getString("fechaRegistro"));
				return proc;
			}
		});
	}

	@Override
	public Proceso getProcesoById(int id) {
		// // TODO Auto-generated method stub
		String sql="SELECT proc.id,proc.idEmpresa,concat(emp.razonSocial,emp.apellidos,emp.nombres) AS 'nombEmpresa',proc.idPersonal,concat(per.email) AS 'nombPersonal',proc.idTipoProceso,tc.nombre AS 'nombTipoProceso',proc.nombreProceso,proc.nombResponsable,proc.descActividades,proc.codeUml,proc.observaciones,proc.fechaRegistro "+ 
				"FROM procesos AS proc "+
				"INNER JOIN personal AS per ON proc.idPersonal = per.id "+
				"INNER JOIN empresas AS emp ON proc.idEmpresa = emp.id "+
				"INNER JOIN tipoprocesos AS tc ON proc.idTipoproceso = tc.id "+
				"WHERE proc.estado = 1 AND proc.id ="+id;
		//System.out.println(sql);
		return template.queryForObject(sql,new BeanPropertyRowMapper<Proceso>(Proceso.class));
	}

	@Override
	public int addProceso(Proceso pro) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO procesos(idPersonal,idEmpresa,idTipoProceso,nombreProceso,nombResponsable,descActividades,codeUml,observaciones,fechaRegistro,estado)"+
				"VALUES ('"+pro.getIdPersonal()+"',1,'"+pro.getIdTipoProceso()+"','"+pro.getNombreProceso()+"','"+pro.getNombResponsable()+"','"+pro.getDescActividades()+"','"+pro.getCodeUml()+"','"+pro.getObservaciones()+"','"+dato.getDateNow()+"','1')";				
		return template.update(query);
	}

	@Override
	public int deleteProceso(int id) {
		String sql="UPDATE procesos SET estado = false WHERE id = "+id;
		return template.update(sql);
	}

	@Override
	public int updateProceso(Proceso pro) {
		String sql="UPDATE procesos "
				+ "SET id = <{id: }>,"
					+ "idPersonal = '"+pro.getIdPersonal()+"',"
					+ "idEmpresa = '"+pro.getIdEmpresa()+"',"
					+ "idTipoProceso = '"+pro.getIdTipoProceso()+"',"
					+ "nombreProceso = '"+pro.getNombreProceso()+"',"
					+ "nombResponsable = '"+pro.getNombResponsable()+"',"
					+ "descActividades = '"+pro.getDescActividades()+"',"
					+ "codeUml = '"+pro.getCodeUml()+"',"
					+ "observaciones = '"+pro.getObservaciones()+"',"
				+"WHERE estado = true AND "+
					"id = "+pro.getId();
		return template.update(sql);
	}
	public List<Proceso> getAllProcesosBy(String val[]) {
		// TODO Auto-generated method stub
		String sql="SELECT proc.*,concat(per.email) AS 'nombPersonal',concat(emp.razonSocial,emp.apellidos,emp.nombres) AS 'nombEmpresa',tc.nombre AS 'nombTipoProceso' FROM procesos AS proc "+
						"INNER JOIN personal AS per ON proc.idPersonal = per.id "+
						"INNER JOIN empresas AS emp ON proc.idEmpresa = emp.id "+
						"INNER JOIN tipoprocesos AS tc ON proc.idTipoproceso = tc.id "+
						"WHERE proc.estado = 1";
		
		if(!val[0].equals("")){
			sql += " AND emp.razonSocial LIKE '%"+val[0]+"%' OR emp.apellidos LIKE '%"+val[0]+"%' OR emp.nombres LIKE '%"+val[0]+"%'";
		}		
		if(!val[1].equals("")){
			sql += " AND proc.nombreProceso LIKE '%"+val[1]+"%'";
		}
		if(!val[2].equals("")){
			sql += " AND proc.idTipoProceso = '"+val[2]+"'";
		}
		if(!val[3].equals("") || !val[4].equals("")){
			sql += " AND proc.fechaRegistro  BETWEEN '"+val[3]+"' AND '"+val[4]+"'";
		}
		
		
		//System.out.println(sql);
		
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
				proc.setNombreProceso(rs.getString("nombreProceso"));
				proc.setNombResponsable(rs.getString("nombResponsable"));
				proc.setDescActividades(rs.getString("descActividades"));
				proc.setCodeUml(rs.getString("codeUml"));
				proc.setObservaciones(rs.getString("observaciones"));
				proc.setFechaRegistro(rs.getString("fechaRegistro"));
				return proc;
			}
		});
	}
	
}
