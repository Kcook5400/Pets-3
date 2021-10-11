package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="pets")
/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Oct 3, 2021
 */
//Colby Boell
public class Pet {
	//variables
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="petname")
	private String petName;
	@Column(name="petType")
	private String petType;
	
	/**
	 * 
	 */
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param petName
	 * @param visitDate
	 * @param petType
	 */
	public Pet(String petName,String petType) {
		super();
		this.petName = petName;
		this.petType = petType;
	}
	//getters/setters



	/**
	 * @return the petName
	 */
	public String getPetName() {
		return petName;
	}



	/**
	 * @param petName the petName to set
	 */
	public void setPetName(String petName) {
		this.petName = petName;
	}


	/**
	 * @return the petType
	 */
	public String getPetType() {
		return petType;
	}



	/**
	 * @param petType the petType to set
	 */
	public void setPetType(String petType) {
		this.petType = petType;
	}
}
