package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.validation.BindingResult;
import com.dao.TipoProcesoDao;
import com.model.TipoProceso;


@Controller
public class TipoProcesoController {

	@Autowired
	private TipoProcesoDao dao;
	
	@RequestMapping(value="/TipoProceso",method=RequestMethod.GET)
	public String getTipoProceso(){
	    return "TipoProceso/frmTipoProceso";
	}
	
	@RequestMapping(value="/listTipoProcesos",method=RequestMethod.GET)	
	public @ResponseBody List<TipoProceso> verListTipoProceso(){
		List<TipoProceso> list =dao.getAllTipoProcesos();
		return list;
	}
	
	@RequestMapping(value="/saveTP",method=RequestMethod.POST)
	public @ResponseBody String agregarProceso(@ModelAttribute(value="tp") TipoProceso tp,BindingResult result ){
		String res = "";
		String id = Integer.toString(tp.getId());
		if(id==null || id.isEmpty() || id.equals("0")){
			dao.addTipoProceso(tp);
			res = "Se ha agregado correctamente";
		}
		else{
			dao.updateTipoProceso(tp);
			res = "Se ha actualizado correctamente";
		}
		
		
		return res;			
	}
	
	@RequestMapping(value="/editTP/{id}",method=RequestMethod.GET)
	public @ResponseBody TipoProceso edit(@PathVariable int id){		
		return dao.getTipoProcesoById(id);
	}
	
	@RequestMapping(value="/deleteTP/{id}",method = RequestMethod.GET)
	public @ResponseBody String  delete(@PathVariable int id){
		String res = "";
		dao.deleteTipoProceso(id);
		res = "Se ha eliminado correctamente";
		return res;	
	}
}
