package it.uniroma3.siw.progetto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.progetto.model.Fotografia;

public interface FotografiaRepository extends CrudRepository<Fotografia, Long> {

	
	 List<Fotografia> findAll();

	 
	
	 Fotografia findByNome(String nome); 
}
