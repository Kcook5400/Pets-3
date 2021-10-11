package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pet;

/**
 * Servlet implementation class addPetServlet
 */
@WebServlet("/addPetServlet")
public class addPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String petName = request.getParameter("petName");
		String petType = request.getParameter("petType");
		
		Pet p = new Pet(petName, petType);
		PetHelper dao = new PetHelper();
		dao.insertPet(p);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}