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

import com.dao.EmpresaDao;
import com.model.Empresa;

@Controller
public class EmpresaController {
	
	@Autowired
	private EmpresaDao dao;
	
	@RequestMapping(value="/Empresa",method=RequestMethod.GET)
	public String getPersonal(){
	    return "Empresa/frmEmpresa";
	}

	@RequestMapping(value="/listEmpresas",method=RequestMethod.GET)	
	public @ResponseBody List<Empresa> verListEmpresas(){
		List<Empresa> list =dao.getAllEmpresas();
		return list;
	}	
	
	@RequestMapping(value="/saveEmp",method=RequestMethod.POST)
	public @ResponseBody String agregarEmpresa(@ModelAttribute(value="emp") Empresa emp,BindingResult result ){
		String res = "";
		String id = Integer.toString(emp.getId());
		if(id==null || id.isEmpty() || id.equals("0")){
			dao.addEmpresa(emp);
			res = "Se ha agregado correctamente";
		}
		else{
			dao.updateEmpresa(emp);
			res = "Se ha actualizado correctamente";
		}		
		return res;			
	}
	
	@RequestMapping(value="/editEmp/{id}",method=RequestMethod.GET)
	public @ResponseBody Empresa edit(@PathVariable int id){		
		return dao.getEmpresaById(id);
	}
	
	@RequestMapping(value="/deleteEmp/{id}",method = RequestMethod.GET)
	public @ResponseBody String delete(@PathVariable int id){
		String res = "";
		dao.deleteEmpresa(id);
		res = "Se ha eliminado correctamente";
		return res;	
	}
	
}
