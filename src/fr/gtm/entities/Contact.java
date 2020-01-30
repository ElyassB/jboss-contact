package fr.gtm.entities;

import java.io.Serializable;

import java.util.HashSet;


import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;



@Entity
@Table(name = "personnes")
@NamedQueries({
	@NamedQuery(name = "Contact.getByNom",
				query = "SELECT c FROM Contact c WHERE c.nom LIKE :nom"),
	@NamedQuery(name= "Contact.getAll", 
				query = "SELECT c FROM Contact c")
})
public class Contact implements Serializable {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk")
	private long id;
	@Enumerated(EnumType.STRING)
	private Civilite civilite;
	private String nom;
	private String prenom;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="contacts_adresses",
		joinColumns=@JoinColumn(name="fk_personne"),
		inverseJoinColumns=@JoinColumn(name="fk_adresse"))
	
	private Set<Adresse> adresses = new HashSet<Adresse>();
	
	public Contact() {}
	
	public Contact(Civilite civilite, String nom, String prenom) {
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Civilite getCivilite() {
		return civilite;
	}
	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	@Override
	public String toString() {
		return "Contact [id=" + id + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + "]";
	}



}
