package it.uniroma3.siw.progetto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.progetto.model.Album;

public interface AlbumRepository extends CrudRepository<Album, Long> {

	public List<Album> findAll();

	public Album findByNome(String nome); 

}
