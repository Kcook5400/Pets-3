package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Oct 3, 2021
 */
public class AppointmentList {
	@Id
	@GeneratedValue
	private int id;
	private String appointmentName;
	private Customer customer;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private LocalDate visitDate;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Pet> petsList;

	/**
	 * 
	 */
	public AppointmentList() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AppointmentList(String appointmentName, Customer customer, LocalDate visitDate) {
		this.appointmentName = appointmentName;
		this.customer = customer;
		this.visitDate = visitDate;
	}

	/**
	 * @param customer
	 * @param visitDate
	 * @param petsList
	 */
	public AppointmentList(String appointmentName,Customer customer, LocalDate visitDate, List<Pet> petsList) {
		super();
		this.appointmentName = appointmentName;
		this.customer = customer;
		this.visitDate = visitDate;
		this.petsList = petsList;
	}

	/**
	 * @param id
	 * @param customer
	 * @param visitDate
	 * @param petsList
	 */
	public AppointmentList(int id, String appointmentName,Customer customer, LocalDate visitDate, List<Pet> petsList) {
		super();
		this.id = id;
		this.appointmentName = appointmentName;
		this.customer = customer;
		this.visitDate = visitDate;
		this.petsList = petsList;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the appointmentName
	 */
	public String getAppointmentName() {
		return appointmentName;
	}
	/**
	 * @param appointmentName the appointmentName to set
	 */
	public void setAppointmentName(String appointmentName) {
		this.appointmentName = appointmentName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public List<Pet> getPetsList() {
		return petsList;
	}

	public void setPetsList(List<Pet> petsList) {
		this.petsList = petsList;
	}
	@Override
	public String toString() {
		return "AppointmentList [id=" + id + ", customer=" + customer + ", visitDate=" + visitDate + ", petsList="
				+ petsList + "]";
	}
	

}
