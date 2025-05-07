package com.simulation.doctors_pi_manipulator.persist.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulation.doctors_pi_manipulator.persist.repository.DoctorsRepository;
import com.simulation.doctors_pi_manipulator.persist.repository.DrugsRepository;
import com.simulation.doctors_pi_manipulator.persist.repository.NotificationRepository;
import com.simulation.doctors_pi_manipulator.persist.entity.Details;
import com.simulation.doctors_pi_manipulator.persist.entity.Drugs;
import com.simulation.doctors_pi_manipulator.persist.entity.Notification;

@Service
public class DrugsService {
	@Autowired
    private DrugsRepository drugsRepository;
    @Autowired
    private DoctorsRepository doctorRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    
    public Drugs addProduct(Drugs product) {
        // Save the product to the database
    	Drugs savedProduct = drugsRepository.save(product);
        // Fetch customers with count > 3
        List<Details> targetedCustomers = doctorRepository.findDoctorsWithActivitiesAboveThreshold();
        // Create notifications for targeted customers
        targetedCustomers.forEach(customer -> {
            Notification notification = new Notification();
            notification.setDoctorId(customer.getDoctorID());
            notification.setDrugId(savedProduct.getDrugID());
            notification.setMessage("Check out our latest product: " + "Drug Name: " + savedProduct.getDrugName() + ", Drug Purpose: " + savedProduct.getPurpose() + ", Drug Side Effects: " + savedProduct.getSideEffects());
            notification.setCreatedAt(LocalDateTime.now());
            notification.setRead(false);
            notificationRepository.save(notification);
        });
        return savedProduct;
    }
}

