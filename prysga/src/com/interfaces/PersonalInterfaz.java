package com.interfaces;

import java.util.List;
import com.model.Personal;

public interface PersonalInterfaz {
	
	public int addPersonal( Personal per );
	public int deletePersonal( int id );
	public int updatePersonal( Personal per );
	public List<Personal> getAllPersonal();
	public Personal getPersonalById( int id );
	public Personal getPersonalByUser(String user, String pass);
	public int validatePersonal(String user, String pass);
	public Personal getPersonalByDni(String dni);

}
