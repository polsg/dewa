package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.interfaces.PersonalInterfaz;
import com.model.Personal;
import com.utilities.Variable;

public class PersonalDao implements PersonalInterfaz{

	private JdbcTemplate template;
	private Variable dato;
	PersonalDao(){
		dato = new Variable();
	}
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public List<Personal> getAllPersonal() {
		String sql="SELECT p.id,p.idCargo,tc.nombre AS 'nombreCargo',p.dni,p.apellidos,p.nombres, p.email,p.claveUsuario, p.direccion, p.telefono FROM personal as p "+
					"INNER JOIN tipocargos AS tc ON p.idCargo = tc.id WHERE p.estado = true";
		return template.query(sql, new RowMapper<Personal>(){
			public Personal mapRow(ResultSet rs, int row) throws SQLException{
				Personal per = new Personal();
				per.setId(rs.getInt("id"));
				per.setIdTipoCargo(rs.getInt("idCargo"));
				per.setNombreCargo(rs.getString("nombreCargo"));
				per.setDni(rs.getString("dni"));
				per.setApellidos(rs.getString("apellidos"));
				per.setNombres(rs.getString("nombres"));
				per.setEmail(rs.getString("email"));
				per.setClaveUsuario(rs.getString("ClaveUsuario"));
				per.setDireccion(rs.getString("direccion"));
				per.setTelefono(rs.getString("telefono"));
				//per.setImagen(rs.getBytes("imagen"));
				return per;
			}
		});
	}
	
	@Override
	public Personal getPersonalById(int id) {
		// TODO Auto-generated method stub
		//String sql="SELECT * FROM personal WHERE estado = true AND id=?";	
		String sql="SELECT p.id,p.idCargo AS 'idTipoCargo',tc.nombre AS 'nombreCargo',p.dni,p.apellidos,p.nombres, p.email,p.claveUsuario, p.direccion, p.telefono,p.imagen FROM personal as p"+
				" INNER JOIN tipocargos AS tc ON p.idCargo = tc.id WHERE p.estado = true AND p.id=?";
		return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<Personal>(Personal.class));
	}
	
	@Override
	public int addPersonal(Personal per) {
		// TODO Auto-generated method stub
		
		String query ="INSERT INTO personal(idTipoCargo,dni,apellidos,nombres,email,claveUsuario,direccion,telefono,fechaRegistro,estado)"+
						"VALUES('"+per.getIdTipoCargo()+"','"+per.getDni()+"','"+per.getApellidos()+"','"+per.getNombres()+"','"+per.getEmail()+"','"+per.getClaveUsuario()+"','"+per.getDireccion()+"','"+per.getTelefono()+"','"+dato.getDateNow()+"','1')";
		return template.update(query);
	}

	@Override
	public int deletePersonal(int id) {
		// TODO Auto-generated method stub
		//String sql="DELETE from personal where id="+id+"";
		String sql="UPDATE personal SET estado = false WHERE id = "+id;
		return template.update(sql);
	}

	@Override
	public int updatePersonal(Personal per) {
		String sql="UPDATE personal "+
				"SET idCargo = '"+per.getIdTipoCargo()+"', "+
					"dni = '"+per.getDni()+"', "+
					"apellidos = '"+per.getApellidos()+"', "+
					"nombres = '"+per.getNombres()+"', "+
					"email = '"+per.getEmail()+"', "+
					"claveUsuario = '"+per.getClaveUsuario()+"', "+
					"direccion = '"+per.getDireccion()+"', "+
					"telefono = '"+per.getTelefono()+"' "+
					//"imagen = '"+per.getImagen()+"', "+					
				"WHERE estado = true AND "+
				"id = "+per.getId();
			return template.update(sql);
	}
	
	@Override
	public int validatePersonal(String user,String pass){		
		String sql="SELECT count(*) FROM personal"
				+ " WHERE estado = 1"
				+ " AND email = '"+user+"'"
				+ " AND claveUsuario = '"+pass+"'";	
		return template.queryForObject(sql,Integer.class);		
	}
	
	@Override
	public Personal getPersonalByUser(String user, String pass) {
		// TODO Auto-generated method stub
		//String sql="SELECT * FROM personal WHERE estado = true AND id=?";	
		String sql="SELECT p.id,p.idCargo AS 'idTipoCargo',tc.nombre AS 'nombreCargo',p.dni,p.apellidos,p.nombres, p.email,p.claveUsuario, p.direccion, p.telefono,p.imagen FROM personal as p"+
				" INNER JOIN tipocargos AS tc ON p.idCargo = tc.id WHERE p.estado = TRUE AND p.email=? AND p.claveUsuario=?";
		return template.queryForObject(sql,new Object[]{user,pass},new BeanPropertyRowMapper<Personal>(Personal.class));
	}
	
	@Override
	public Personal getPersonalByDni(String dni) {
		// TODO Auto-generated method stub
		//String sql="SELECT * FROM personal WHERE estado = true AND id=?";	
		String sql="SELECT p.id,p.idCargo AS 'idTipoCargo',tc.nombre AS 'nombreCargo',p.dni,p.apellidos,p.nombres, p.email,p.claveUsuario, p.direccion, p.telefono,p.imagen FROM personal as p"+
				" INNER JOIN tipocargos AS tc ON p.idCargo = tc.id WHERE p.estado = TRUE AND p.dni='"+dni+"'";
		
		System.out.println(sql);
		return template.queryForObject(sql,new BeanPropertyRowMapper<Personal>(Personal.class));
	}
}
