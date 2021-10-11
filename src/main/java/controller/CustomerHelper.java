package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Customer;


/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Oct 8, 2021
 */
public class CustomerHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ShoppingList");
	
	public void insertCustomer(Customer customer) {
		EntityManager em= emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
		em.close();
		
	}

	/**
	 * 
	 */
	public CustomerHelper() {
		// TODO Auto-generated constructor stub
	}

	public Customer findCustomer (String customerName) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Customer> typedQuery = em.createQuery("select cus from customer cus where customer.customerName = :selectedName",Customer.class);
		typedQuery.setParameter("selectedName", customerName);
		typedQuery.setMaxResults(1);
		Customer foundCustomer;
		try {
			foundCustomer = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundCustomer = new Customer(customerName);
		}
		em.close();

		return foundCustomer;
	}
	
}
