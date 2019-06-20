package it.uniroma3.siw.progetto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.siw.progetto.model.FileModel;



@Controller
public class FilesController {

	
	@RequestMapping("/addFiles")
	public String addStudente(Model model) {
		model.addAttribute("file", new FileModel());
		return "homePage.html";
	}
}
