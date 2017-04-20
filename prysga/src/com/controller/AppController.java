package com.controller;
//import com.model.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dao.PersonalDao;
import com.model.Personal;




@Controller
//@SessionAttributes("personObj")
public class AppController {
	@Autowired
	private PersonalDao dao;
	
	  @RequestMapping(value = "/Admin", method = RequestMethod.GET)
	   public String index(HttpSession session) {
		  if(session.getAttribute("dni") != null){
			  return "Admin";
		  }
		  else
		  {
			  return "Login";
		  }
	   }
	  
	  @RequestMapping(value = "/logout", method = RequestMethod.POST)
	  public @ResponseBody String logout(HttpSession session) {
	    session.invalidate();
	    return "/prysga/";
	  }
	   
	   @RequestMapping(value = "/", method = RequestMethod.GET)
	   public String Admin(HttpSession session) {
		  
		  if(session.getAttribute("dni") != null){
			  return "Admin";
		  }
		  else
		  {
			  return "Login";
		  }
	      
	   }  
	   
		@RequestMapping(value="/validarUser",method=RequestMethod.POST)	
		public @ResponseBody String validateUser(@RequestParam("user") String user,@RequestParam("pass") String pass, HttpSession session){
			Personal per = new Personal();
			int val = dao.validatePersonal(user.trim(),pass.trim());
			if(val==1){
				per = dao.getPersonalByUser(user, pass);
				//session.setMaxInactiveInterval(10);
				session.setAttribute("hola", per.getNombres().toUpperCase());
				session.setAttribute("dni", per.getDni());
				session.setAttribute("user", per.getTipocargo());
				//System.out.println(per.getNombres());
				return "true:Admin";	
			}else{
				return "false:/";
			}
					
		}
		
		
		@RequestMapping(value="/Usuario",method=RequestMethod.GET)
		public String getPersonal(){
		    return "Usuario/frmUsuario";
		}
		
		@RequestMapping(value="/verUser",method=RequestMethod.GET)
		public @ResponseBody Personal verUserbyDni(HttpSession session){	
			System.out.println(session.getAttribute("dni").toString());
			return dao.getPersonalByDni(session.getAttribute("dni").toString());
		}
		

}
