package com.simulation.doctors_pi_manipulator.persist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "drugs")
public class Drugs {
	
	@Id
	@Column(name = "id") // Maps the field to the 'id' column in the table
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer drugID;
	
	@Column(name = "drug_name") // Maps the field to the 'drug_name' column
	private String drugName;

	@Column(name = "purpose") // Maps the field to the purpose column
	private String purpose;
	
	@Column(name = "drug_type") // Maps the field to the drug_type column
	private String drugType;
	
	@Column(name = "side_effects") // Maps the field to the side_effects column
	private String sideEffects;


	public Integer getDrugID() {
		return drugID;
	}

	public void setDrugID(Integer drugID) {
		this.drugID = drugID;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getDrugType() {
		return drugType;
	}

	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}

	public String getSideEffects() {
		return sideEffects;
	}

	public void setSideEffects(String sideEffects) {
		this.sideEffects = sideEffects;
	}



}
