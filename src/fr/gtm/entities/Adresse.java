package fr.gtm.entities;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;

@Entity
@Table(name="adresses")

public class Adresse {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk")
	private int id;
	private String rue;
	@Column(name="code_postal")
	private String codePostal;
	private String ville;
	private String pays;
	

	
	

	public Adresse() {
		
	}
	public Adresse(int id, String rue, String codePostal, String ville, String pays) {
		
		this.id = id;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", pays="
				+ pays + "]";
	}
	
	
	

}
