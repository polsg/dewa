package com.analytic;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.util.StringTokenizer;

import com.model.*;

public class Analizador {
	
	private static String tagged;
	private static String msj;
	
	public String asignarTokens(String sample){		
		// Initialize the tagger
        MaxentTagger tagger = new MaxentTagger("com/files/spanish-distsim.tagger");     
        tagged = tagger.tagString(sample);        
		return tagged;
	}
	
	public String getWordsTokens(String val){		
		String[] palabratokens;
        String valToken="";
        palabratokens = val.split("\\s");
        for (int i = 0; i < palabratokens.length; i++) {        	
        	valToken +=palabratokens[i]+" ";
            //System.out.println(palabratokens[i]);
        }			
		return valToken.trim();
	}
	
	public String getTokens(String val){		
		String[] palabratokens,tokens;
        String valToken="";
        palabratokens = val.split("\\s");
        for (int i = 0; i < palabratokens.length; i++) {
        	tokens = palabratokens[i].split("_");
        	for(int j=0;j < tokens.length;j++){
        		if(j%2!=0){
        			valToken += tokens[j]+" ";
        		}
        	}
            //System.out.println(palabratokens[i]);
        }			
		return valToken.trim();
	}	
	
	public String separarOracion(String val,String paso)
	{	
		String mensaje="";
		String empiezo="";
		String condicional="";
		String sujeto="";
		String predicado="";
		//String msj="";
		Oracion ora = new Oracion();
		Validacion as = new Validacion();
		
		//System.out.println(paso.charAt(0));
	
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
	}	
	
	
	
}
