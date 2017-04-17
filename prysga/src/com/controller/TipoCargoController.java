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



import com.dao.TipoCargoDao;
import com.model.TipoCargo;


@Controller
public class TipoCargoController {
	@Autowired
	private TipoCargoDao dao;
	
	@RequestMapping(value="/TipoCargo",method=RequestMethod.GET)
	public String getTipoCargo(){
	    return "TipoCargo/frmTipoCargo";
	}
	
	@RequestMapping(value="/listTipoCargos",method=RequestMethod.GET)	
	public @ResponseBody List<TipoCargo> verListTipoCargo(){
		List<TipoCargo> list =dao.getAllTipoCargos();
		return list;
	}
	
	@RequestMapping(value="/saveTC",method=RequestMethod.POST)
	public @ResponseBody String agregarProceso(@ModelAttribute(value="tc") TipoCargo tc,BindingResult result ){
		String res = "";
		String id = Integer.toString(tc.getId());
		if(id==null || id.isEmpty() || id.equals("0")){
			dao.addTipoCargo(tc);
			res = "Se ha agregado correctamente";
		}
		else{
			dao.updateTipoCargo(tc);
			res = "Se ha actualizado correctamente";
		}
		
		
		return res;			
	}
	
	@RequestMapping(value="/editTC/{id}",method=RequestMethod.GET)
	public @ResponseBody TipoCargo edit(@PathVariable int id){		
		return dao.getTipoCargoById(id);
	}
	
	@RequestMapping(value="/deleteTC/{id}",method = RequestMethod.GET)
	public @ResponseBody String  delete(@PathVariable int id){
		String res = "";
		dao.deleteTipoCargo(id);
		res = "Se ha eliminado correctamente";
		return res;	
	}

	/*It saves object into database. The @ModelAttribute puts request data
	 
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("tc") TipoCargo tc){
		dao.save(tc);
		return new ModelAndView("redirect:/viewemp");//will redirect to viewemp request mapping
	}


	@RequestMapping(value="/editemp/{id}")
	public ModelAndView edit(@PathVariable int id){
		Emp emp=dao.getEmpById(id);
		return new ModelAndView("empeditform","command",emp);
	}

	@RequestMapping(value="/editsave",method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("emp") Emp emp){
		dao.update(emp);
		return new ModelAndView("redirect:/viewemp");
	}
	
	@RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id){
		dao.delete(id);
		return new ModelAndView("redirect:/viewemp");
	}*/
}
