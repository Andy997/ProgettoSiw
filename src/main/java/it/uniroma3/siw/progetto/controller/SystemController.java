package it.uniroma3.siw.progetto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.progetto.model.Admin;
import it.uniroma3.siw.progetto.model.Album;
import it.uniroma3.siw.progetto.model.Fotografia;
import it.uniroma3.siw.progetto.model.Fotografo;
import it.uniroma3.siw.progetto.model.Ricerca;
import it.uniroma3.siw.progetto.model.Richiesta;
import it.uniroma3.siw.progetto.services.AdminServices;
import it.uniroma3.siw.progetto.services.AdminValidator;
import it.uniroma3.siw.progetto.services.AlbumServices;
import it.uniroma3.siw.progetto.services.FotografiaServices;
import it.uniroma3.siw.progetto.services.FotografiaValidator;
import it.uniroma3.siw.progetto.services.FotografoServices;
import it.uniroma3.siw.progetto.services.RichiestaServices;
import it.uniroma3.siw.progetto.services.RichiestaValidator;

@Controller
public class SystemController {

	@Autowired
	private AlbumServices albumServices;

	@Autowired
	private FotografiaServices fotografiaServices;

	@Autowired
	private FotografoServices fotografoServices;

	@Autowired
	private AdminServices adminServices;

	@Autowired
	private FotografiaValidator fotografiaValidator;

	@Autowired
	private AdminValidator adminValidator;

	@Autowired
	private RichiestaServices richiestaServices;

	@Autowired
	private RichiestaValidator richiestaValidator;
	/*@RequestMapping("/")
	public String initializa(Model model, HttpSession session) {
		session.setAttribute("fotoRichieste", new ArrayList<Fotografia>());
		session.setAttribute("utenteCorrente", new Utente());
		session.setAttribute("richieste", new ArrayList<Richiesta>());
		model.addAttribute("admin", new Admin());
		List<Fotografia> foto = fotografiaServices.tutte();
		model.addAttribute("fotografie", foto);
		model.addAttribute("ricerca", new Ricerca());
		return "/homePage";
	}*/


	@RequestMapping(value ="/homePage", method=RequestMethod.GET)
	public String newAlbum(Model model) {
		List<Fotografia> foto = fotografiaServices.tutte();
		model.addAttribute("fotografie", foto);
		model.addAttribute("ricerca", new Ricerca());
		model.addAttribute("admin", new Admin());
		List<Album> albums = albumServices.tutti();
		Collections.reverse(albums);
		//prendo gli ultimi album inseriti
		//IMPLEMENTARE CONTROLLO NUMERO ALBUMS
		for(int i=0; i<3; i++){
			Album album = albums.get(0);
			model.addAttribute("album" + i, album);
			model.addAttribute("copertina" + i, albumServices.getCopertina(album));
			albums.remove(0);
		}
		return "homePage.html";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	private String search(@Valid @ModelAttribute("ricerca") Ricerca ricerca, Model model, BindingResult bindingResult) {
		String nextPage="";
		if(!ricerca.getRicerca().isEmpty()) {
			if(ricerca.getOggettoRicerca().equals("Fotografia")) {
				List<Fotografia> photos = new ArrayList<>();
				for(Fotografia f : fotografiaServices.tutte()) {
					if(f.getNome().contains(ricerca.getRicerca()))
						photos.add(f);
				}
				model.addAttribute("fotoCercate",photos);
				nextPage="fotografieCercate.html";
			}
			if(ricerca.getOggettoRicerca().equals("Album")) {
				List<Album> albums = new ArrayList<>();
				for(Album a : albumServices.tutti()) {
					if(a.getNome().contains(ricerca.getRicerca()))
						albums.add(a);
				}
				model.addAttribute("albumsCercate",albums);
				nextPage="albumsCercati.html";
			}
			if(ricerca.getOggettoRicerca().equals("Fotografo")) {
				List<Fotografo> fotografi = new ArrayList<>();
				for(Fotografo f : fotografoServices.tutti()) {
					if(f.getNome().contains(ricerca.getRicerca()))
						fotografi.add(f);
				}
				model.addAttribute("fotografiCercate",fotografi);
				nextPage ="fotografiCercati.html";
			}
		}
		return nextPage;
	}
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String login(HttpSession session, Model model, @ModelAttribute("admin")Admin admin, BindingResult bindingResult) {
		String nextPage="error.html";
		adminValidator.validate(admin, bindingResult);
		if(!bindingResult.hasErrors()) {
			Admin a = adminServices.trovaPerUsername(admin.getUsername());
			if(a.getPassword().equals(admin.getPassword())) {
				session.setAttribute("admin", a);
				nextPage="login.html";}
		}
		return nextPage;
	}

	@RequestMapping(value="/salvataggio", method=RequestMethod.GET)
	public String save(Model model) {
		model.addAttribute("fotografo", new Fotografo());
		model.addAttribute("album", new Album());
		model.addAttribute("fotografia", new Fotografia());
		return "save.html";
	}

	@RequestMapping(value="/ricerca", method=RequestMethod.GET)
	public String search(Model model) {
		model.addAttribute("fotografo", new Fotografo());
		model.addAttribute("album", new Album());
		model.addAttribute("fotografia", new Fotografia());
		return "search.html";
	}

	@RequestMapping(value="/aggiungiRichiesta/{id}")
	public String addRequest(@PathVariable("id") Long id, Model model, HttpSession session) {
		List<Fotografia> fotoRichieste =(List<Fotografia>) session.getAttribute("fotoRichieste");
		if(fotoRichieste == null) {
			fotoRichieste=new ArrayList<Fotografia>();
			session.setAttribute("fotoRichieste", fotoRichieste);
		}
		if(id!=null) {
			Fotografia fotografia = fotografiaServices.trovaPerId(id);
			fotoRichieste.add(fotografia);
			session.setAttribute("fotoRichieste", fotoRichieste);
			return "redirect:/homePage";
		}
		else 
			return "error.html";
	}

	@RequestMapping(value="/resocontoRichiesta")
	public String infoRequest(Model model, HttpSession session) {
		List<Fotografia> fotoRichieste =(List<Fotografia>)session.getAttribute("fotoRichieste");
		if(fotoRichieste!=null) {
		model.addAttribute("richiesta",new Richiesta());
		model.addAttribute("fotoRichieste", fotoRichieste);
		return "newRichiesta.html";
		}
		else 
			return "invalidRequest.html";
	}

	@RequestMapping(value="/inviaRichiesta")
	public String submitRequest(HttpSession session,@ModelAttribute("richiesta") Richiesta richiesta, BindingResult bindingResult) {
		richiestaValidator.validate(richiesta,bindingResult);
		if(!bindingResult.hasErrors()) {
			List<Fotografia> fotoRichieste = (List<Fotografia>)session.getAttribute("fotoRichieste");
			richiesta.setFotografie(fotoRichieste);
			richiestaServices.inserisci(richiesta);
			fotoRichieste.clear();
			session.setAttribute("fotoRichieste", fotoRichieste);
			return "success.html";
		}
		else 
			return "newRichiesta.html";
	}

	@RequestMapping(value="/forms")
	public String showForms(Model model) {
		List<Richiesta> richieste = richiestaServices.tutte();
		model.addAttribute("richieste", richieste);
		return "forms.html";

	}


}
