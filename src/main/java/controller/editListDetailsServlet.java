package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AppointmentList;
import model.Customer;
import model.Pet;

/**
 * Servlet implementation class editDetailsListServlet
 */
@WebServlet("/editListDetailsServlet")
public class editListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AppointmentListHelper dao = new AppointmentListHelper();
		PetHelper lih = new PetHelper();
		CustomerHelper sh = new CustomerHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		AppointmentList listToUpdate = dao.searchForListDetailsById(tempId);
		String newappointmentName = request.getParameter("appointmentName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String CustomerName = request.getParameter("CustomerName");
		// find our add the new Customer
		Customer newCustomer = sh.findCustomer(CustomerName);
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		try {
			// items are selected in list to add
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<Pet> selectedItemsInList = new ArrayList<Pet>();
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Pet c = lih.searchForPetById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			listToUpdate.setPetsList(selectedItemsInList);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<Pet> selectedItemsInList = new ArrayList<Pet>();
			listToUpdate.setPetsList(selectedItemsInList);
		}
		listToUpdate.setAppointmentName(newappointmentName);
		listToUpdate.setVisitDate(ld);
		listToUpdate.setCustomer(newCustomer);
		dao.updateList(listToUpdate);
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
