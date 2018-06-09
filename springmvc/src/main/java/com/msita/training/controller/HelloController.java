package com.msita.training.controller;

import com.msita.training.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	private HomeService homeService;

	@RequestMapping(method = RequestMethod.GET)
	public String printHello(HttpServletRequest request, ModelMap model) {

		String name = null;
		String dis = null;
		String ox = null;
		model.addAttribute("listProduct", homeService.getProducts());
		String user = (String) request.getSession().getAttribute("username");
		if (user != null) {
			name = "logout";
			dis = "changepass";
		} else {
			name = "login";
			dis = "signup";
			user = " ";
		}
		model.addAttribute("name", name);
		model.addAttribute("dis", dis);
		model.addAttribute("user", user);
		return "home";
	}
}