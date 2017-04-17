package com.interfaces;

import java.util.List;
import com.model.Proceso;

public interface ProcesoInterfaz {

	public int addProceso( Proceso pro );
	public int deleteProceso( int id );
	public int updateProceso( Proceso pro );
	public List<Proceso> getAllProcesos();
	public Proceso getProcesoById( int id );
}
