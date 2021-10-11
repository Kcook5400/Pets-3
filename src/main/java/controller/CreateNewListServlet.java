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

import model.Pet;
import model.Customer;
import model.AppointmentList;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppointmentListHelper lih = new AppointmentListHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String CustomerName = request.getParameter("CustomerName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
			}
		catch (NumberFormatException ex) {
			ld = LocalDate.now();
			}
		String [] selectedItems= request.getParameterValues("allPetsToAdd");
		List<AppointmentList> selectedItemsInList = new ArrayList <AppointmentList> ();
		if(selectedItems != null && selectedItems.length > 0) {
			for (int i =0; i<selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				AppointmentList c = lih.searchForListDetailsById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			
		}
		Customer customer = new Customer(CustomerName);
		AppointmentList sld = new AppointmentList(listName, customer, ld);
		sld.setPetsList(selectedItemsInList);
		AppointmentListHelper slh = new AppointmentListHelper();
		slh.insertNewListDetails(sld);
		
		System.out.println("Success!");
		System.out.println(sld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
