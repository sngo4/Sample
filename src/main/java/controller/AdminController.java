/*---------------------------------------------Sang----------------------------------------------------------------*/
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import model.Loging;
import service.LogingService;


@Controller
@RequestMapping("/")
public class AdminController {
	
	
	@Autowired
	@Qualifier("logingService")
	LogingService logingService;
	
	
	@RequestMapping(value = { "/","/login" }, method = RequestMethod.GET)
	public String login(ModelMap model) {
		Loging loging = new Loging();
		model.addAttribute("loging", loging);
		return "index";	
	}
	
	@RequestMapping(value = { "/","/login" }, method = RequestMethod.POST)
	public String loginForm(@Valid Loging loging, 
			ModelMap model, HttpServletRequest requestLoging){
		System.out.println("sang loging" + loging.getIdLogin());
		Loging manager = logingService.checkLoging(loging.getUsername(), loging.getPassword());
		
		if(manager != null){
		requestLoging.getSession().setAttribute("manager", manager);
			
			return "redirect:/account/list";
		}
		return "redirect:/";
	}
	
	
}
