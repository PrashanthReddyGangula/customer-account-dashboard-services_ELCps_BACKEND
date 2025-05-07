package com.simulation.doctors_pi_manipulator.persist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityId;

    @Column(name = "doctor_id")
    private String doctorId;

    @Column(name = "drug_id")
    private Integer drugId;

    @Column(name = "response_to_email")
    private String responseToEmail;

    @Column(name = "endorsement_status")
    private String endorsementStatus;

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer id) {
		this.activityId = id;
	}

	public String getDoctor() {
		return doctorId;
	}

	public void setDoctor(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getResponseToEmail() {
		return responseToEmail;
	}

	public void setResponseToEmail(String responseToEmail) {
		this.responseToEmail = responseToEmail;
	}

	public String getEndorsementStatus() {
		return endorsementStatus;
	}

	public void setEndorsementStatus(String endorsementStatus) {
		this.endorsementStatus = endorsementStatus;
	}

    
}