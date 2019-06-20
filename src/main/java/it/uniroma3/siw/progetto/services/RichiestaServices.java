package it.uniroma3.siw.progetto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.progetto.model.Richiesta;
import it.uniroma3.siw.progetto.repository.RichiestaRepository;

@Service
public class RichiestaServices {

	@Autowired
	private RichiestaRepository richiestaRepository;
	
	@Transactional
	public List<Richiesta> tutte(){
		return (List<Richiesta>) richiestaRepository.findAll();
	}
	
	@Transactional
	public Richiesta inserisci(Richiesta richiesta) {
		return richiestaRepository.save(richiesta);
	}

	public void deleteAll() {
		richiestaRepository.deleteAll();
		
	}
}
