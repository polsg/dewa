package com.utilities;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Variable {
	
	public String getDateNow(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date dato = new Date();
		return dateFormat.format(dato);
	}

}
