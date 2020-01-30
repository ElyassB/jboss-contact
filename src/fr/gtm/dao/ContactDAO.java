package fr.gtm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.gtm.entities.Civilite;
import fr.gtm.entities.Contact;




public class ContactDAO extends AbstractDAO<Contact, Long>{
	private EntityManagerFactory emf;

	public ContactDAO(EntityManagerFactory emf) {
		super(emf, Contact.class);
		this.emf = this.getEntityManagerFactory();
	}
	
	
	public List<Contact> getContactsByCivilite(Civilite civilite){
		String sql = "SELECT c FROM Contact c WHERE c.civilite= :foo";
		EntityManager em = emf.createEntityManager();
		List<Contact> contacts = em.createQuery(sql, Contact.class)
										.setParameter("foo", civilite)
										.getResultList();
		em.close();
		return contacts;
	}
	
	public List<Contact> getContactsByNom(String nom){
		EntityManager em = emf.createEntityManager();
		List<Contact> contacts = em.createNamedQuery("Contact.getByNom", Contact.class)
										.setParameter("nom", nom+"%")
										.getResultList();
		em.close();
		return contacts;
	}

	public List<Contact> getAllContact() {
		EntityManager em = emf.createEntityManager();
		List<Contact> contacts = em.createNamedQuery("Contact.getAll", Contact.class)
										.getResultList();
		em.close();
		return contacts;
	}
	
	public List<Contact> getContactsByAdresse(String adresse){
		EntityManager em = emf.createEntityManager();
		List<Contact> contacts = em.createNamedQuery("Contact.getByNom", Contact.class)
										.setParameter("adresse", adresse+"%")
										.getResultList();
		em.close();
		return contacts;
	}

}
