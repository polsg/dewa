package com.analytic;


public class Validacion {

	public boolean validarOracion(String tokens){
		boolean val;
		String[] values = tokens.split(" ");
		for(int t=0; t<values.length;t++){
			
		}			
		return true;
	}
	
	
	public boolean validarPredicado(String val){		
		String[] tokens = val.split(" ");		
		for(int p = 0; p<tokens.length;p++)
		{
			if(tokens[p].equals("vmip000")){
				return true;
			}
		}	
		return false;
	}
	
	public int posicVerbo(String val){
		int pos=0;		
		String[] tokens = val.split(" ");		
		for(int p = 0; p<tokens.length;p++)
		{
			if(tokens[p].equals("vmip000")){
				pos = p;
			}
		}		
		return pos;
	}
	
	public boolean validarCondicional(){
		
		return true;
	}
	
	
	

}
