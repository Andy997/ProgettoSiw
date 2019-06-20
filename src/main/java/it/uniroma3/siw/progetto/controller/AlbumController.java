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
import it.uniroma3.siw.progetto.services.AlbumServices;
import it.uniroma3.siw.progetto.services.AlbumValidator;

@Controller
public class AlbumController {

	@Autowired
	private AlbumServices albumServices;

	@Autowired
	private AlbumValidator albumValidator;

	@RequestMapping(value="/saveAlbum", method=RequestMethod.POST)
	private String newFotografo(@Valid @ModelAttribute("album") Album album,
			@Valid @ModelAttribute("fotografia") Fotografia fotografia,
			BindingResult bindingResult) {
		albumValidator.validate(album, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.albumServices.inserisciAlbum(album);
			return "done.html";	
		}
		else
			return "save.html";		
	}

	@RequestMapping(value="/searchAlbum", method=RequestMethod.POST)
	private String newFotografo(@Valid @ModelAttribute("album") Album album, Model model) {
		String nextPage="error.html";
		if(album.getNome()!=null) {
			model.addAttribute("album", albumServices.albumPerNome(album.getNome()));
			nextPage="album.html";
		}
		return nextPage;
	}
}
