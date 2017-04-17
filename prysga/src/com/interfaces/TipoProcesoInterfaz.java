package com.interfaces;

import java.util.List;
import com.model.TipoProceso;

public interface TipoProcesoInterfaz {
	
	public int addTipoProceso( TipoProceso tipoproceso );
	public int deleteTipoProceso( int id );
	public int updateTipoProceso( TipoProceso tipoproceso );
	public List<TipoProceso> getAllTipoProcesos();
	public TipoProceso getTipoProcesoById( int id );
}
