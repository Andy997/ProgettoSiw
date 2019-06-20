package it.uniroma3.siw.progetto.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Fotografia {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String nome;

	/*@OneToOne(cascade = CascadeType.PERSIST)
	private FileModel file;*/
	
	@Column
	public String url;

	@ManyToOne
	@JoinColumn
	private Album album;

	@Column
	public Double prezzo;
	
	public Fotografia() {}


	public Fotografia(String nome, String url,Double prezzo ) {
		this.nome = nome;
		this.url = url;
		this.prezzo = prezzo;
	}
	

	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public Double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}


	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}







}
