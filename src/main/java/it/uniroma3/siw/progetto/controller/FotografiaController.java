package it.uniroma3.siw.progetto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.progetto.model.Album;
import it.uniroma3.siw.progetto.model.Fotografia;
import it.uniroma3.siw.progetto.services.FotografiaServices;
import it.uniroma3.siw.progetto.services.FotografiaValidator;

@Controller
public class FotografiaController {

	@Autowired
	private FotografiaServices fotografiaServices;
	
	@Autowired
	private FotografiaValidator fotografiaValidator;
	
	@RequestMapping(value="/saveFotografia", method=RequestMethod.POST)
	public String newFotografia(@Valid @ModelAttribute("fotografia") Fotografia fotografia,
			 BindingResult bindingResult) {
		fotografiaValidator.validate(fotografia, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.fotografiaServices.inserisciFotografia(fotografia);
			return "done.html";	
		}
		else
			return "save.html";		
	}
	
	@RequestMapping(value="/searchFotografia", method=RequestMethod.POST)
	public String searchFotografia(@Valid @ModelAttribute("fotografia") Fotografia fotografia, Model model) {
		String nextPage="error.html";
		if(fotografia.getNome()!=null) {
			model.addAttribute("fotografia", fotografiaServices.findPerNome(fotografia.getNome()));
			nextPage="fotografia.html";
		}
		return nextPage;
	}
}
