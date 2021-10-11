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
@WebServlet("/editPetServlet")
public class editPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       PetHelper dao = new PetHelper();
		
		String petName = request.getParameter("petName");
		String petType = request.getParameter("petType");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
				
		Pet itemToUpdate = dao.searchForPetById(tempId);
		itemToUpdate.setPetName(petName);
		itemToUpdate.setPetType(petType);
				
		dao.updatePet(itemToUpdate);

		getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);

	}

}
