package it.uniroma3.siw.progetto.model;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Richiesta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	@OneToMany
	private List<Fotografia> fotografie;
	
	@Column
	private String nomeUtente;
	
	

	@Column
	private String cognomeUtente;

	public Richiesta() {
		super();
	}

	public Richiesta(List<Fotografia> fotografie, String nome, String cognome) {
		this.fotografie = fotografie;
		this.cognomeUtente=cognome;
		this.nomeUtente = nome;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Fotografia> getFotografie() {
		return fotografie;
	}

	public void setFotografie(List<Fotografia> fotografie) {
		this.fotografie = fotografie;
	}
	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getCognomeUtente() {
		return cognomeUtente;
	}

	public void setCognomeUtente(String cognomeUtente) {
		this.cognomeUtente = cognomeUtente;
	}
}
