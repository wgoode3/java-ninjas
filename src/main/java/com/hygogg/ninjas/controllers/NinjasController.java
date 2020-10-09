package com.hygogg.ninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hygogg.ninjas.models.Ninja;
import com.hygogg.ninjas.models.Technique;
import com.hygogg.ninjas.services.NinjaService;
import com.hygogg.ninjas.services.TechniqueService;


@Controller
public class NinjasController {

	private static NinjaService ninServ;
	private static TechniqueService techServ;
	
	public NinjasController(NinjaService ninServ, TechniqueService techServ) {
		this.ninServ = ninServ;
		this.techServ = techServ;
	}
	
	@GetMapping("/")
	public String index(@RequestParam(value="search", required=false) String search, Model model) {
		System.out.println(search);
		if(search == null) {
			model.addAttribute("ninjas", ninServ.getAll());			
		} else {
			model.addAttribute("ninjas", ninServ.search(search));	
		}
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
	
	@GetMapping("/ninjas/{id}/delete")
	public String removeNinja(@PathVariable("id") Long id) {
		ninServ.remove(id);
		return "redirect:/";
	}
	
	@GetMapping("/ninjas/top/3")
	public String top3(Model model) {
		model.addAttribute("ninjas", ninServ.top3ninjaMastersYo());
		return "topNinjas.jsp";
	}
	
	@GetMapping("/techs/new")
	public String newTechs(Model model) {
		model.addAttribute("allNinjas", ninServ.getAll());
		model.addAttribute("newTech", new Technique());
		return "newTech.jsp";
	}
	
	@PostMapping("/techs")
	public String addTechs(@Valid @ModelAttribute("newTech") Technique newTech, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allNinjas", ninServ.getAll());
			return "newTech.jsp";
		}
		techServ.create(newTech);
		return "redirect:/";
	}
	
	@PostMapping("/addtech")
	public String addTechAgain(@RequestParam("name") String name, @RequestParam("ninja") Long ninja_id, RedirectAttributes flash) {
		Technique jutsu = new Technique(name);
		if(name.length() < 3) {
			flash.addFlashAttribute("nameError", "Technique name must be 3 characters or longer!");
			return "redirect:/ninjas/" + ninja_id;
		}
		jutsu.setNinja( ninServ.getOne(ninja_id) );
		techServ.create(jutsu);
		return "redirect:/ninjas/" + ninja_id;
	}
	
}
