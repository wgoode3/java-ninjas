package com.hygogg.ninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hygogg.ninjas.models.Ninja;
import com.hygogg.ninjas.services.NinjaService;


@Controller
public class NinjasController {

	private static NinjaService ninServ;
	
	public NinjasController(NinjaService ninServ) {
		this.ninServ = ninServ;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("ninjas", ninServ.getAll());
		return "index.jsp";
	}
	
	@PostMapping("/ninjas")
	public String create(@ModelAttribute("ninja") Ninja ninja) {
		ninServ.create(ninja);
		return "redirect:/";
	}
	
}
