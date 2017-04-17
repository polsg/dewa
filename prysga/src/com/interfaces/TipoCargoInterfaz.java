package com.interfaces;

import java.util.List;
import com.model.TipoCargo;

public interface TipoCargoInterfaz {
	
	public int addTipoCargo( TipoCargo tipocargo );
	public int deleteTipoCargo( int id );
	public int updateTipoCargo( TipoCargo tipocargo );
	public List<TipoCargo> getAllTipoCargos();
	public TipoCargo getTipoCargoById( int id );
}
