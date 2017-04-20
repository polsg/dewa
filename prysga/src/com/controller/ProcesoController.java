package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.dao.ProcesoDao;
import com.model.*;



import com.analytic.*;
@Controller
public class ProcesoController {
	
	@Autowired
	private ProcesoDao dao;
	
	@RequestMapping(value="/gestProceso",method = RequestMethod.GET)
	public String getGestProceso(){
	    return "Proceso/frmProceso";
	}
	
	@RequestMapping(value="/Modelador",method = RequestMethod.GET)
	public String getGestModelador(){
	    return "Proceso/frmModelador";
	}

	@RequestMapping(value="/listProcesos",method = RequestMethod.GET)	
	public @ResponseBody List<Proceso> verListProcesos(){
		List<Proceso> list =dao.getAllProcesos();
		return list;
	}	
	
	@RequestMapping(value="/saveProc",method = RequestMethod.POST)
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
	
	@RequestMapping(value="/analizarTexto",method = RequestMethod.POST)
	public @ResponseBody Oracion procesarTexto(@ModelAttribute(value="te") Texto te, BindingResult result, ModelMap model){	
			
		String[] texto = te.getActividad().split(">");	
		Analizador a1 = new Analizador();
		Oracion o1 = new Oracion();		
		
			a1.asignarTokens(texto[1].trim());			
			o1 = a1.analize(a1.getTokens(), a1.getWords());	
			//System.out.print(a1.getTokens()+"\n"+ a1.getWords());	
			
		return o1;
	}
	
	@RequestMapping(value="/Diagram",method = RequestMethod.GET)
	public String getGetDiagram(){
	    return "Proceso/Diagram";
	}
	
	@RequestMapping(value="/listProcesosBy",method = RequestMethod.POST)	
	public @ResponseBody List<Proceso> verListProcesosBy(@RequestParam("empresa") String emp,@RequestParam("proceso") String proc,@RequestParam("tiproce") String tiproc,@RequestParam("fecini") String fecini,@RequestParam("fecfin") String fecfin){
		
		String val[] = new String[5]; 
		
		val[0] = emp.trim();
		val[1] = proc.trim();
		val[2] = tiproc.trim();
		val[3] = fecini.trim();
		val[4] = fecfin.trim();
		
		List<Proceso> list =dao.getAllProcesosBy(val);
		return list;
	}	
	
	@RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
	public ModelAndView downloadPdf() {
		List<Proceso> list =dao.getAllProcesos();	
		return new ModelAndView("pdfView", "listProcesos", list);
	}
	
	@RequestMapping(value = "/verPdf/{id}", method = RequestMethod.GET)
	public ModelAndView verPdf(@PathVariable int id) {	
		Proceso pro = new Proceso();
		pro = dao.getProcesoById(id);
		//System.out.println(pro.getId());
		
		return new ModelAndView("pdfViewProc", "listActs", pro);
	}
	
	
	
}
