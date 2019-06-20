package it.uniroma3.siw.progetto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.progetto.model.Fotografo;

public interface FotografoRepository extends CrudRepository<Fotografo, Long> {
	
	public List<Fotografo> findAll();

	public Fotografo findByNomeAndCognome(String nome, String cognome);

}
