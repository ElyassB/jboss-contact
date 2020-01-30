package fr.gtm.web;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.dao.ContactDAO;
import fr.gtm.entities.Contact;


@WebServlet("/AllAdressesServlet")
public class AllAdressesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactDAO dao = (ContactDAO) getServletContext().getAttribute("contactDao");
		String page = "/show-adresses.jsp";
		Long id = Long.parseLong(request.getParameter("id"));
		Contact contact = dao.findById(id);
		request.setAttribute("contact", contact);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
