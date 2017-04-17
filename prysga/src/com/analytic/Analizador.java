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
	
	public Oracion analTexto(String tokens,String words){
		Validacion v1 = new Validacion();
		Oracion o1 = new Oracion();
		String[] oracion = words.trim().split(" ");
		String sujeto="";
		String predicado="";
			if(v1.validarPredicado(tokens))
			{						
				for(int s=0; s<v1.posicVerbo(tokens);s++){
					sujeto += oracion[s]+" ";
				}
				
				for(int p=v1.posicVerbo(tokens);p<oracion.length;p++){
					predicado += oracion[p]+" ";
				}
				o1.setSujeto(sujeto);
				o1.setPredicado(predicado);
				o1.setMensaje("oracion correcta");
				o1.setEstado("true");
			}
			else
			{				
				o1.setMensaje("no existe el verbo indicado");
				o1.setEstado("false");
			}
		return o1;
		
	}
	
/*	public String separarOracion(String val,String paso)
	{	
		String mensaje="";
		String empiezo="";
		String condicional="";
		String sujeto="";
		String predicado="";
		//String msj="";
		
		Validacion as = new Validacion();
		
			
		String[] sepaOra = paso.split(">");
		
		
		String[] oracion = sepaOra[1].trim().split(" ");
		
		
		if(Integer.parseInt(sepaOra[0].trim()) != 1){		
			empiezo =" ";
		}else{
			empiezo ="\n start";
		}
		
		if(as.validarPredicado(val)){
			
			for(int s=0; s<as.posicVerbo(val);s++){
				sujeto += oracion[s]+" ";
			}
			
			for(int p=as.posicVerbo(val);p<oracion.length;p++){
				predicado += oracion[p]+" ";
			}	
			
			msj="true";
		}else{
			predicado = "no existe el verbo indicado";
			msj="false";
		}	
		mensaje = msj+" > |"+sujeto.trim()+"| "+empiezo+" \n :"+predicado.trim()+";";
		
		
		
		//mensaje = msj;
		return mensaje;
	}	*/
	
	
	
}
