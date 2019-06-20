package it.uniroma3.siw.progetto.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.progetto.model.Album;
import it.uniroma3.siw.progetto.model.Fotografia;
import it.uniroma3.siw.progetto.repository.AlbumRepository;

@Service
public class AlbumServices {

	@Autowired
	private AlbumRepository albumRepository;

	@Transactional
	public List<Album> tutti() {
		return (List<Album>)albumRepository.findAll();
	}
	
	@Transactional
	public Fotografia getCopertina(Album album) {
		return album.getFotografie().get(0);
	}

	@Transactional
	public void inserisciAlbum(@Valid Album album) {
		albumRepository.save(album);
	}
	
	@Transactional
	public Album albumPerNome(String nome) {
		return albumRepository.findByNome(nome);
	}
	
	
}
