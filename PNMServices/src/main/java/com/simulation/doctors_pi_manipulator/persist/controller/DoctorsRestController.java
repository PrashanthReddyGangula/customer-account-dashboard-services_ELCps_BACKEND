package com.simulation.doctors_pi_manipulator.persist.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simulation.doctors_pi_manipulator.persist.entity.Details;
import com.simulation.doctors_pi_manipulator.persist.service.DoctorsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/doctors")
public class DoctorsRestController {

	
	@Autowired
	private DoctorsService doctorsService;
	
	
	// Fetch doctor's fullName by ID
	@GetMapping("/{id}")
	public ResponseEntity<String> fetchDoctor(@PathVariable("id") String id) {
		Optional<Details> optionalDetails = doctorsService.getDoctorById(id);
		Details doctor = optionalDetails.orElse(null);
		if (doctor != null) {
			return ResponseEntity.ok(doctor.getFullName());
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	// Fetch doctor's full details by ID
		@GetMapping("/details/{id}")
		public ResponseEntity<Details> fetchDoctorDetails(@PathVariable("id") String id) {
			Optional<Details> optionalDetails = doctorsService.getDoctorById(id);
			Details doctor = optionalDetails.orElse(null);
			if (doctor != null) {
				return ResponseEntity.ok(doctor);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
	
	// Update an existing doctor's details
	   @PutMapping("/update/{id}")
		public String updateDoctor(@PathVariable("id") String id, @RequestBody Details details) {
			Details result = doctorsService.updateDoctor(id, details);
			if (result != null) {
				return "Updated";
			} else {
				return "Not found";
			}
		}
	
	
}
