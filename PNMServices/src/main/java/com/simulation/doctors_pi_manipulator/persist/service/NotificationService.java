package com.simulation.doctors_pi_manipulator.persist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulation.doctors_pi_manipulator.persist.entity.Notification;
import com.simulation.doctors_pi_manipulator.persist.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getUnreadNotifications(String customerId) {
        // Fetch unread notifications sorted by latest first
        return notificationRepository.findUnreadNotificationsByDoctorId(customerId);
    }
}
