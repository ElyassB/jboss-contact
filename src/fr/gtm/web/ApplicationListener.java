package fr.gtm.web;

import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.gtm.dao.ContactDAO;


@WebListener
public class ApplicationListener implements ServletContextListener {
	private static Logger LOG = Logger.getLogger(ApplicationListener.class.getName());

   


    public void contextDestroyed(ServletContextEvent sce)  { 
    	LOG.info(">>> arrêt de l'application");
    	ServletContext application = sce.getServletContext(); 
        EntityManagerFactory emf = (EntityManagerFactory) application.getAttribute("EMF");
        emf.close();
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         LOG.info(">>> démarrage de l'application");
         // contexte applicatif
         ServletContext application = sce.getServletContext();
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("contacts");
         application.setAttribute("EMF", emf);
         ContactDAO contactDao = new ContactDAO(emf);
         application.setAttribute("contactDao", contactDao);
    }
	
}
