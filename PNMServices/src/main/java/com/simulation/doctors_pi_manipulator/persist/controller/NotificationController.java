package com.simulation.doctors_pi_manipulator.persist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simulation.doctors_pi_manipulator.persist.entity.Notification;
import com.simulation.doctors_pi_manipulator.persist.service.NotificationService;


@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{doctorId}")
    public ResponseEntity<List<String>> getUnreadNotifications(@PathVariable("doctorId") String doctorId) {
        List<Notification> notificationsList = notificationService.getUnreadNotifications(doctorId);
        // Initialize messagesList outside the loop
        List<String> messagesList = new ArrayList<>();
        
        // Populate messagesList
        notificationsList.forEach(notific -> messagesList.add(notific.getMessage()));

        return ResponseEntity.ok(messagesList);
    }
}

