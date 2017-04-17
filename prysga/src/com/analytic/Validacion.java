package com.analytic;


public class Validacion {	
	
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
}
