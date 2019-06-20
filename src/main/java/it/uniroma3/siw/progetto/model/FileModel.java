package it.uniroma3.siw.progetto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class FileModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable=false)
	private String nome;
    
	@Column(nullable=false)
	private String tipo;
	
	@Lob
	@Column(nullable=false)
    private byte[] pic;
	
	
	
	
	public FileModel(String name, String type, byte[] pic){
		this.nome = name;
		this.tipo = type;
		this.pic = pic;
	}
	
	public FileModel() {
		// TODO Auto-generated constructor stub
	}


	
	public String getName(){
		return this.nome;
	}
	
	public void setName(String name){
		this.nome = name;
	}
	
	public String getType(){
		return this.tipo;
	}
	
	public void setType(String type){
		this.tipo = type;
	}
	
	public byte[] getPic(){
		return this.pic;
	}
	
	public void setPic(byte[] pic){
		this.pic = pic;
	}

}
