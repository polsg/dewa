package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.interfaces.EmpresaInterfaz;
import com.model.Empresa;
import com.utilities.Variable;

public class EmpresaDao implements EmpresaInterfaz{

	private JdbcTemplate template;
	private Variable dato;
	EmpresaDao(){
		dato = new Variable();
	}
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public List<Empresa> getAllEmpresas() {
		String sql="SELECT * FROM empresas";
		return template.query(sql, new RowMapper<Empresa>(){
			public Empresa mapRow(ResultSet rs, int row) throws SQLException{
				Empresa emp = new Empresa();
				emp.setId(rs.getInt("id"));
				emp.setRuc(rs.getString("ruc"));
				emp.setRazonSocial(rs.getString("razonSocial"));
				emp.setDni(rs.getString("dni"));
				emp.setApellidos(rs.getString("apellidos"));
				emp.setNombres(rs.getString("nombres"));
				emp.setDireccion(rs.getString("direccion"));
				emp.setEmail(rs.getString("email"));
				emp.setTelefono(rs.getString("telefono"));
				emp.setObservaciones(rs.getString("observaciones"));				
				return emp;
			}
		});
	}
	
	@Override
	public Empresa getEmpresaById(int id) {
		// TODO Auto-generated method stub
		//String sql="SELECT * FROM Empresa WHERE estado = true AND id=?";	
		String sql="SELECT * FROM empresas WHERE estado = true AND id=?";
		return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<Empresa>(Empresa.class));
	}
	 
	@Override
	public int addEmpresa(Empresa emp) {
		// TODO Auto-generated method stub		
		String query ="INSERT INTO empresas(ruc,razonSocial,dni,apellidos,nombres,direccion,email,telefono,observaciones,fechaRegistro,estado)"+
						"VALUES('"+emp.getRuc()+"','"+emp.getRazonSocial()+"','"+emp.getDni()+"','"+emp.getApellidos()+"','"+emp.getNombres()+"','"+emp.getDireccion()+"','"+emp.getEmail()+"','"+emp.getTelefono()+"','"+emp.getObservaciones()+"','"+dato.getDateNow()+"','1')";
		return template.update(query);
	}

	@Override
	public int deleteEmpresa(int id) {
		// TODO Auto-generated method stub
		//String sql="DELETE from Empresa where id="+id+"";
		String sql="UPDATE empresas SET estado = false WHERE id = "+id;
		return template.update(sql);
	}

	@Override
	public int updateEmpresa(Empresa emp) {
		String sql="UPDATE empresas "+
				"SET ruc = '"+emp.getRuc()+"', "+
					"razonSocial = '"+emp.getRazonSocial()+"', "+
					"dni = '"+emp.getDni()+"', "+
					"apellidos = '"+emp.getApellidos()+"', "+
					"nombres = '"+emp.getNombres()+"', "+
					"direccion = '"+emp.getDireccion()+"', "+
					"email = '"+emp.getEmail()+"', "+
					"telefono = '"+emp.getTelefono()+"', "+
					"observaciones = '"+emp.getObservaciones()+"' "+
				"WHERE estado = true AND "+
				"id = "+emp.getId();
			return template.update(sql);
	}
}
