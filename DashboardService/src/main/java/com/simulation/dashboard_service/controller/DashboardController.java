package com.simulation.dashboard_service.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simulation.dashboard_service.entity.Details;
import com.simulation.dashboard_service.proxy.DoctorsServerProxy;
import com.simulation.dashboard_service.proxy.NotificationsServerProxy;
import com.simulation.dashboard_service.service.MessageSender;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {
	
	@Autowired
	private DoctorsServerProxy dsProxy;
	@Autowired
	private NotificationsServerProxy nsProxy;
	
	@Autowired
	private final MessageSender messageSender;

    public DashboardController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }
	@GetMapping("/ELPdashboard")
	public String greet() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication != null && authentication.isAuthenticated()) {
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	                
	        return dsProxy.retrieveDoctorFullName(userDetails.getUsername());
	    } else {
	        return "Please log in to access the dashboard";
	    }	
	}
	
	@GetMapping("/notifications")
	public List<String> updates() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		List<String> messagesList = nsProxy.retrieveNotifications(userDetails.getUsername());
        return messagesList;
	}

	@GetMapping("/profile")
	public Details profile() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		Details details = dsProxy.retrieveDoctorDetails(userDetails.getUsername());
        return details;
	}
    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        messageSender.sendMessage(userDetails.getUsername()+":"+message);
        System.out.println(userDetails.getUsername());
        
        return ResponseEntity.ok("Message sent to RabbitMQ successfully.");   
    }
}
