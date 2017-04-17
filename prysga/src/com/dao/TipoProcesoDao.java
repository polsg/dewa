package com.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.interfaces.TipoProcesoInterfaz;
import com.model.TipoProceso;
import com.utilities.*;


public class TipoProcesoDao implements TipoProcesoInterfaz{

	private JdbcTemplate template;
	private Variable dato;
	TipoProcesoDao(){
		dato = new Variable();
	}
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public List<TipoProceso> getAllTipoProcesos() {
		// TODO Auto-generated method stub	
		String query = "SELECT * FROM tipoprocesos WHERE estado = true";
		return template.query(query,new RowMapper<TipoProceso>(){
			public TipoProceso mapRow(ResultSet rs, int row) throws SQLException {
				TipoProceso tp=new TipoProceso();
				tp.setId(rs.getInt(1));
				tp.setNombre(rs.getString(2));

				return tp;
			}
		});
	}

	@Override
	public TipoProceso getTipoProcesoById(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM tipoprocesos WHERE estado = true AND id=?";
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<TipoProceso>(TipoProceso.class));
	}

	
	@Override
	public int addTipoProceso(TipoProceso tp) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO tipoprocesos (nombre,fechaRegistro,estado) "+
					"VALUES('"+tp.getNombre()+"','"+dato.getDateNow()+"','1')";

		return template.update(sql);
	}

	@Override
	public int deleteTipoProceso(int id) {
		// TODO Auto-generated method stub
		//String sql="delete from TipoProcesos where id="+id+"";
		String sql="UPDATE tipoprocesos SET estado = false WHERE id = "+id;
		return template.update(sql);
	}

	@Override
	public int updateTipoProceso(TipoProceso tp) {
		// TODO Auto-generated method stub
		String sql="UPDATE tipoprocesos SET "+
				"nombre = '"+tp.getNombre()+"' "+
				"WHERE estado = true AND "+
				"id = "+tp.getId();
			return template.update(sql);
	}


}
