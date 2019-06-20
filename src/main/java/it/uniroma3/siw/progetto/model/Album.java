package it.uniroma3.siw.progetto.model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;




@Entity
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "album")
	private List<Fotografia> fotografie;

	@Column
	private LocalDate dataCaricamento;

	private String descrizione;

	private String nome;
	
	@ManyToOne
	private Fotografo fotografo;
	


	
	

	public Album() {
		super();
	}

	public Album(List<Fotografia> fotografie, String descrizione, String nome) {
		this.fotografie = fotografie;
		setAlbum();
		this.dataCaricamento = LocalDate.now();
		this.descrizione=descrizione;
		this.nome = nome;
		
	}
	
	public Fotografo getFotografo() {
		return fotografo;
	}

	public void setFotografo(Fotografo fotografo) {
		this.fotografo = fotografo;
	}

	

	private void setAlbum() {
		for(Fotografia f:this.fotografie){
			f.setAlbum(this);
		}
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getDataCaricamento() {
		return dataCaricamento;
	}

	public void setDataCaricamento(LocalDate dataCaricamento) {
		this.dataCaricamento = dataCaricamento;
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

	

}
