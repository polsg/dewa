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

import com.dao.PersonalDao;
import com.model.Personal;

@Controller
public class PersonalController {
	
	@Autowired
	private PersonalDao dao;
	
	@RequestMapping(value="/Personal",method=RequestMethod.GET)
	public String getPersonal(){
	    return "Personal/frmPersonal";
	}
	
	@RequestMapping(value="/listPersonal",method=RequestMethod.GET)	
	public @ResponseBody List<Personal> verListPersonal(){
		List<Personal> list =dao.getAllPersonal();
		return list;
	}	
	
	@RequestMapping(value="/savePer",method=RequestMethod.POST)
	public @ResponseBody String agregarPersonal(@ModelAttribute(value="per") Personal per,BindingResult result ){
		String res = "";
		String id = Integer.toString(per.getId());
		if(id==null || id.isEmpty() || id.equals("0")){
			dao.addPersonal(per);
			res = "Se ha agregado correctamente";
		}
		else{
			dao.updatePersonal(per);
			res = "Se ha actualizado correctamente";
		}		
		return res;			
	}
	
	@RequestMapping(value="/editPer/{id}",method=RequestMethod.GET)
	public @ResponseBody Personal edit(@PathVariable int id){		
		return dao.getPersonalById(id);
	}
	
	@RequestMapping(value="/deletePer/{id}",method = RequestMethod.GET)
	public @ResponseBody String delete(@PathVariable int id){
		String res = "";
		dao.deletePersonal(id);
		res = "Se ha eliminado correctamente";
		return res;	
	}
}
