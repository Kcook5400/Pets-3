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
 * Servlet implementation class createNewListServlet2
 */
@WebServlet("/createNewListServlet2")
public class createNewListServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewListServlet2() {
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
		PetHelper lih = new PetHelper();
		String appointmentName = request.getParameter("appointmentName");
		System.out.println("List Name: "+ appointmentName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String customerName = request.getParameter("customerName");
		LocalDate ld;
		try {
		ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
		ld = LocalDate.now();
		}
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<Pet> selectedItemsInList = new ArrayList<Pet>();
		if (selectedItems != null && selectedItems.length > 0) 
		{
		for(int i = 0; i<selectedItems.length; i++) {
		System.out.println(selectedItems[i]);
		Pet c = lih.searchForPetById(Integer.parseInt(selectedItems[i]));
		selectedItemsInList.add(c);
		}
		}
		Customer customer = new Customer(customerName);
		AppointmentList sld = new AppointmentList(appointmentName, customer, ld);
		sld.setPetsList(selectedItemsInList);
		AppointmentListHelper slh = new AppointmentListHelper();
		slh.insertNewListDetails(sld);
		System.out.println("Success!");
		System.out.println(sld.toString());
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
