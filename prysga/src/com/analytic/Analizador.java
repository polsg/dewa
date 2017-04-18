package com.analytic;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;


public class Analizador {
	
	private static String tagged;
	
	public String asignarTokens(String sample){		
		// Initialize the tagger
        MaxentTagger tagger = new MaxentTagger("com/files/spanish-distsim.tagger");     
        tagged = tagger.tagString(sample);        
		return tagged;
	}
	
	public String getTokens(){		
		String[] palabratokens,tokens;
        String valTokens="";
        palabratokens = tagged.split("\\s");
        for (int i = 0; i < palabratokens.length; i++) {
        	tokens = palabratokens[i].split("_");
        	for(int j=0;j < tokens.length;j++){
        		if(j%2!=0){
        			valTokens += tokens[j]+" ";
        		}
        	}    
        }			
		return valTokens.trim();
	}	
	
	public String getWords(){		
		String[] palabratokens,tokens;
        String valWords="";
        palabratokens = tagged.split("\\s");
        for (int i = 0; i < palabratokens.length; i++) {
        	tokens = palabratokens[i].split("_");
        	for(int j=0;j < tokens.length;j++){
        		if(j%2==0){
        			valWords += tokens[j]+" ";
        		}
        	}
        }			
		return valWords.trim();
	}
	
	public Oracion analize(String tokens,String words){
		Validacion v1 = new Validacion();
		Oracion o1 = new Oracion();
		String[] oracion = words.trim().split(" ");
		String sujeto="";
		String predicado="";
		String condicion="";
		
			if(oracion[0].toUpperCase().equals("SI")){
				if(v1.buscarComa(words.trim()))
				{
					for(int s=1; s<v1.posicComa(tokens);s++){
						condicion += oracion[s]+" ";
					}
					System.out.print(condicion);
					o1.setCondicion(condicion);
				}
				else
				{
					o1.setMensaje("La oracion condicional no valida");
					o1.setEstado("false");
				}
				
			}else{
				if(v1.validarPredicado(tokens))
				{						
					for(int s=0; s<v1.posicVerbo(tokens);s++){
						sujeto += oracion[s]+" ";
					}
					
					for(int p=v1.posicVerbo(tokens);p<oracion.length;p++){
						predicado += oracion[p]+" ";
					}
					o1.setSujeto(sujeto.trim());
					o1.setPredicado(predicado.trim());
					o1.setMensaje("oracion correcta");
					o1.setEstado("true");
				}
				else
				{				
					o1.setMensaje("no existe el verbo indicado");
					o1.setEstado("false");
				}
			}
		
			
		return o1;
		
	}
	

	
	
	
}
