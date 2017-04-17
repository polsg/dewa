package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.dao.ProcesoDao;
import com.model.*;
import com.analytic.*;
@Controller
public class ProcesoController {
	
	@Autowired
	private ProcesoDao dao;
	
	@RequestMapping(value="/Proceso",method=RequestMethod.GET)
	public String getGestProceso(){
	    return "Proceso/frmProceso";
	}
	
	@RequestMapping(value="/Modelador",method=RequestMethod.GET)
	public String getGestModelador(){
	    return "Proceso/frmModelador";
	}

	@RequestMapping(value="/listProcesos",method=RequestMethod.GET)	
	public @ResponseBody List<Proceso> verListProcesos(){
		List<Proceso> list =dao.getAllProcesos();
		return list;
	}	
	
	@RequestMapping(value="/saveProc",method=RequestMethod.POST)
	public @ResponseBody String agregarProceso(@ModelAttribute(value="proc") Proceso proc,BindingResult result ){
		String res = "";
		String id = Integer.toString(proc.getId());
		if(id==null || id.isEmpty() || id.equals("0")){
			dao.addProceso(proc);
			res = "Se ha agregado correctamente";
		}
		else{
			dao.updateProceso(proc);
			res = "Se ha actualizado correctamente";
		}		
		return res;			
	}
	
	@RequestMapping(value="/editProc/{id}",method=RequestMethod.GET)
	public @ResponseBody Proceso edit(@PathVariable int id){		
		return dao.getProcesoById(id);
	}
	
	@RequestMapping(value="/deleteProc/{id}",method = RequestMethod.GET)
	public @ResponseBody String delete(@PathVariable int id){
		String res = "";
		dao.deleteProceso(id);
		res = "Se ha eliminado correctamente";
		return res;	
	}
	
	@RequestMapping(value="/setTokens",method=RequestMethod.POST)
	public @ResponseBody String procesoDiagrama(@ModelAttribute(value="te") Texto te,BindingResult result,ModelMap model){	
		Analizador anle = new Analizador();		
		
		String[] sepaOra = te.getActividad().split(">");
		//System.out.println(sepaOra[1]);
		
		String res = anle.asignarTokens(sepaOra[1].trim());	
		
		return anle.separarOracion(anle.getTokens(res),te.getActividad());		
	}
	
	@RequestMapping(value="/Diagram",method=RequestMethod.GET)
	public String getGetDiagram(){
	    return "Proceso/Diagram";
	}
	
}
