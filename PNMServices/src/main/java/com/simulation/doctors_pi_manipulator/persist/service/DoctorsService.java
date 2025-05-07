package com.simulation.doctors_pi_manipulator.persist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.simulation.doctors_pi_manipulator.persist.entity.Details;

import com.simulation.doctors_pi_manipulator.persist.repository.DoctorsRepository;

@Service
public class DoctorsService {
	
	@Autowired
    private DoctorsRepository doctorsRepository;

    public Optional<Details> getDoctorById(String id) {
        return doctorsRepository.findById(id);
    }
	
    public Details updateDoctor(String id, Details updatedDoctor) {
        return doctorsRepository.findById(id)
            .map(doctor -> {
            	doctor.setFullName(updatedDoctor.getFullName());
            	doctor.setEmailAddress(updatedDoctor.getEmailAddress());
            	doctor.setPhoneNumber(updatedDoctor.getPhoneNumber());
            	doctor.setCountry(updatedDoctor.getCountry());
            	doctor.setSpecialization(updatedDoctor.getSpecialization());
        
                return doctorsRepository.save(doctor);
            }).orElse(null);
    }
    
    public List<Details> findDoctorsWithActivitiesAboveThreshold() {
        // Delegate the logic to the repository layer
        return doctorsRepository.findDoctorsWithActivitiesAboveThreshold();
    }
	
}
