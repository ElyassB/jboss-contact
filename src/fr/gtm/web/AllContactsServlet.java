package fr.gtm.web;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import fr.gtm.dao.ContactDAO;
import fr.gtm.entities.Contact;


@WebServlet("/AllContactsServlet")
public class AllContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(AllContactsServlet.class.getName());
       
    
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactDAO dao = (ContactDAO) getServletContext().getAttribute("contactDao");
		String page = "/show-contacts.jsp";
		List<Contact> contacts = dao.getAllContact();
		request.setAttribute("contacts", contacts);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
