package it.uniroma3.siw.progetto.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.progetto.model.Fotografia;
import it.uniroma3.siw.progetto.repository.FotografiaRepository;

@Service
public class FotografiaServices {

	@Autowired
	private FotografiaRepository fotografiaRepository;
	
	@Transactional
	public List<Fotografia> tutte(){
		return (List<Fotografia>)fotografiaRepository.findAll();
	}
	
	@Transactional
	public void inserisciFotografia(@Valid Fotografia fotografia) {
		fotografiaRepository.save(fotografia);	
	}

	@Transactional
	public Fotografia findPerNome(String nome) {
		return fotografiaRepository.findByNome(nome);
	}

	@Transactional
	public Fotografia trovaPerId(Long id) {
		return fotografiaRepository.findById(id).get();
	}
}
