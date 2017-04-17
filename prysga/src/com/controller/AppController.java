package com.controller;
//import com.model.*;

import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class AppController {
	  
	  @RequestMapping(value = "/Login", method = RequestMethod.GET)
	   public String index() {
		  return "Login";
	   }
	   
	   @RequestMapping(value = "/", method = RequestMethod.GET)
	   public String Admin() {	     
	      return "Admin";
	   }   
}
