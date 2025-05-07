package com.simulation.doctors_pi_manipulator.persist.controller;

import com.simulation.doctors_pi_manipulator.persist.service.MessageListener;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class MessageController {

	@Autowired
    private final MessageListener messageListener;

    public MessageController(MessageListener messageListener) {
        this.messageListener = messageListener;
    }

    @GetMapping("/get/messages")
    public List<String> getMessagesForDashboard() {
        // Fetch messages from the MessageListener
        return messageListener.getReceivedMessages();
    }
}
