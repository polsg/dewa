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

	public boolean buscarComa(String val) {
		String[] tokens = val.split(" ");		
		for(int p = 0; p<tokens.length;p++)
		{
			if(tokens[p].equals(",")){
				return true;
			}
		}	
		return false;
	}
	
	public int posicComa(String val){
		int pos=0;		
		String[] tokens = val.split(" ");		
		for(int p = 0; p<tokens.length;p++)
		{
			if(tokens[p].equals("fc")){
				pos = p;
			}
		}		
		return pos;
	}
}
