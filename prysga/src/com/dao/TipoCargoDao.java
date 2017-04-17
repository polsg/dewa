package com.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.interfaces.TipoCargoInterfaz;
import com.model.TipoCargo;
import com.utilities.*;


public class TipoCargoDao implements TipoCargoInterfaz{

	private JdbcTemplate template;
	private Variable dato;
	TipoCargoDao(){
		dato = new Variable();
	}
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public List<TipoCargo> getAllTipoCargos() {
		// TODO Auto-generated method stub	
		String query = "SELECT * FROM tipocargos WHERE estado = true";
		return template.query(query,new RowMapper<TipoCargo>(){
			public TipoCargo mapRow(ResultSet rs, int row) throws SQLException {
				TipoCargo tc=new TipoCargo();
				tc.setId(rs.getInt(1));
				tc.setNombre(rs.getString(2));

				return tc;
			}
		});
	}

	@Override
	public TipoCargo getTipoCargoById(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM tipocargos WHERE estado = true AND id=?";
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<TipoCargo>(TipoCargo.class));
	}

	
	@Override
	public int addTipoCargo(TipoCargo tc) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO tipocargos (nombre,fechaRegistro,estado) "+
					"VALUES('"+tc.getNombre()+"','"+dato.getDateNow()+"','1')";

		return template.update(sql);
	}

	@Override
	public int deleteTipoCargo(int id) {
		// TODO Auto-generated method stub
		//String sql="delete from tipocargos where id="+id+"";
		String sql="UPDATE tipocargos SET estado = false WHERE id = "+id;
		return template.update(sql);
	}

	@Override
	public int updateTipoCargo(TipoCargo tc) {
		// TODO Auto-generated method stub
		String sql="UPDATE tipocargos SET "+
				"nombre = '"+tc.getNombre()+"' "+
				"WHERE estado = true AND "+
				"id = "+tc.getId();
			return template.update(sql);
	}


}
