package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AppointmentList;
/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Oct 8, 2021
 */
public class AppointmentListHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("pets");

	public void insertNewListDetails(AppointmentList app) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(app);
		em.getTransaction().commit();
		em.close();
		
	}

	public List<AppointmentList> getLists(){
		EntityManager em= emfactory.createEntityManager();
		List<AppointmentList> allAppointments = em.createQuery("Select a FROM Appointments d").getResultList();
		return allAppointments;
		
	}

	public void deleteAppointment(AppointmentList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AppointmentList> typedQuery = em.createQuery("select Appointment from AppointmentList  Appointment  where Appointment.id= :selectedId", AppointmentList.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		AppointmentList result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	public AppointmentList searchForListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		AppointmentList found = em.find(AppointmentList.class, tempId);
		em.close();
		return found;
		
	}
	public void updateList(AppointmentList toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	/**
	 * 
	 */
	public AppointmentListHelper() {
		// TODO Auto-generated constructor stub
	}

}
