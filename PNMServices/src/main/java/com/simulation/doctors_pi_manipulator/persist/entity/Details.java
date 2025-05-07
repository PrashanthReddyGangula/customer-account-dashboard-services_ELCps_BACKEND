package com.simulation.doctors_pi_manipulator.persist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctors") // This maps the entity to the "doctors" table in the database
public class Details {

	@Id
	@Column(name = "id") // Maps the field to the 'id' column in the table
	private String doctorID;

	@Column(name = "full_name") // Maps the field to the 'full_name' column
	private String fullName;

	@Column(name = "email") // Maps the field to the email column
	private String emailAddress;
	
	@Column(name = "phone_number") // Maps the field to the phone_number column
	private String phoneNumber;
	
	

	@Column(name = "country") // Maps the field to the country column
	private String country;

	@Column(name = "specialization") // Maps the field to the specialization column
	private String specialization;

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	

}

