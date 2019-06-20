package it.uniroma3.siw.progetto.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.progetto.model.Fotografo;
import it.uniroma3.siw.progetto.repository.FotografoRepository;

@Service
public class FotografoServices {

	@Autowired
	private FotografoRepository fotografoRepository;

	@Transactional
	public List<Fotografo> tutti(){
		return (List<Fotografo>)fotografoRepository.findAll();
	}

	@Transactional
	public void inserisciFotografo(@Valid Fotografo fotografo) {
		fotografoRepository.save(fotografo);

	}

	@Transactional
	public Fotografo fotografoPerNomeAndCognome(String nome, String cognome) {
		return fotografoRepository.findByNomeAndCognome(nome, cognome);
	}
}
