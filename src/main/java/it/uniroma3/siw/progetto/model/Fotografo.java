package it.uniroma3.siw.progetto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fotografo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "fotografo")
	private List<Album> albums;

	@Column
	private String nome;
	
	@Column
	private String cognome;
	


	public Fotografo() {
	}

	public Fotografo(String nome,String cognome, List<Album> albums) {
		this.nome =nome;
		this.albums = albums;
		this.cognome=cognome;
		setFotografo();
	}
	
	private void setFotografo() {
		for(Album a: this.albums) 
			a.setFotografo(this);
	}
	
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
