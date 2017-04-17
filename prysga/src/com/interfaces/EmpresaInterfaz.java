package com.interfaces;

import java.util.List;
import com.model.Empresa;

public interface EmpresaInterfaz {
	
	public int addEmpresa( Empresa per );
	public int deleteEmpresa( int id );
	public int updateEmpresa( Empresa per );
	public List<Empresa> getAllEmpresas();
	public Empresa getEmpresaById( int id );

}
