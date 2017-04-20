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
		String[] tok = tokens.trim().split(" ");
		String sujeto="";
		String predicado="";
		String condicion="";
	
		
			if(oracion[0].toUpperCase().equals("SI")){
				if(v1.buscarComa(words.trim()))
				{
					for(int c=1; c<v1.posicComa(tokens);c++)
					{
						condicion += oracion[c]+" ";						
					}					
										
					String[] cond = words.trim().split(",");
					String[] oraCon = cond[1].trim().split(" ");
					String tokensOracion="";
					//System.out.println(cond[1].trim()+": "+cond.length+": "+oraCon.length+": "+tok.length);
					for(int ot=v1.posicComa(tokens)+1; ot<tok.length;ot++)
					{
						tokensOracion += tok[ot]+" ";						
					}
					tokensOracion.trim();
					//System.out.println(tokensOracion.trim());
					if(v1.validarPredicado(tokensOracion))
					{		
						//System.out.println(v1.posicVerbo(tokensOracion));
						for(int s=0; s<v1.posicVerbo(tokensOracion);s++){
							sujeto += oraCon[s]+" ";
						}
						
						for(int p=v1.posicVerbo(tokensOracion);p<oraCon.length;p++){
							predicado += oraCon[p]+" ";
						}
						
						
						o1.setCondicion(condicion.trim());
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
				else
				{
					o1.setMensaje("La oracion condicional no valida : No se encuentra la coma");
					o1.setEstado("false");
				}
				
			}
			else if(oracion[0].toUpperCase().equals("SINO"))
			{
				if(v1.validarPredicado(tokens))
				{						
					for(int s=1; s<v1.posicVerbo(tokens);s++){
						sujeto += oracion[s]+" ";
					}
					
					for(int p=v1.posicVerbo(tokens)+1;p<oracion.length;p++){
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
			else{
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
