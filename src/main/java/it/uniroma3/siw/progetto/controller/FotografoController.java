package it.uniroma3.siw.progetto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.progetto.model.Fotografo;
import it.uniroma3.siw.progetto.services.FotografoServices;
import it.uniroma3.siw.progetto.services.FotografoValidator;

@Controller
public class FotografoController {
	
	@Autowired
	private FotografoServices fotografoServices;
	
	@Autowired
	private FotografoValidator fotografoValidator;
	
	@RequestMapping(value="/saveFotografo", method=RequestMethod.POST)
	public String newFotografo(@Valid @ModelAttribute("fotografo") Fotografo fotografo,
			 BindingResult bindingResult) {
		fotografoValidator.validate(fotografo, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.fotografoServices.inserisciFotografo(fotografo);
			return "done.html";	
		}
		else
			return "save.html";		
	}
	
	@RequestMapping(value="/searchFotografo", method=RequestMethod.GET)
	public String searchFotografo(@Valid @ModelAttribute("fotografo") Fotografo fotografo, Model model) {
		String nextPage="error.html";
		if(fotografo.getNome()!=null) {
			model.addAttribute("fotografo", fotografoServices.fotografoPerNomeAndCognome(fotografo.getNome(), fotografo.getCognome()));
			nextPage="fotografo.html";
		}
		return nextPage;
	}
}
