package com.hygogg.ninjas.controllers;

import java.sql.ResultSet;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.addAttribute("newNinja", new Ninja());
		return "index.jsp";
	}
	
	@PostMapping("/ninjas")
	public String create(@Valid @ModelAttribute("newNinja") Ninja newNinja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			// if invalid re-render the page
			// pass along any models that the page needs (like a list of ninja for the table)
			model.addAttribute("ninjas", ninServ.getAll());
			return "index.jsp";
		} else {	
			// if the ninja is valid save them to the db
			// and then redirect
			ninServ.create(newNinja);
			return "redirect:/";
		}
	}
	
	@GetMapping("/ninjas/{id}")
	public String ninjaDetails(@PathVariable("id") Long id, Model model) {
		model.addAttribute("singleNinja", ninServ.getOne(id));
		return "ninja.jsp";
	}
	
	@PostMapping("/ninjas/{id}/update")
	public String updateNinja(@PathVariable("id") Long id, @Valid @ModelAttribute("singleNinja") Ninja singleNinja, BindingResult result) {
		if(result.hasErrors()) {
			return "ninja.jsp";
		} else {
			ninServ.update(singleNinja, id);
			return "redirect:/ninjas/" + id;
		}
	}
	
}
