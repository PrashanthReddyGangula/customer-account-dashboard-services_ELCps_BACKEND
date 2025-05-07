package com.simulation.doctors_pi_manipulator.persist.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

	 // Thread-safe list to store received messages
    private final List<String> receivedMessages = new CopyOnWriteArrayList<>();

    @RabbitListener(queues = "customerMessagesQueue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        // Add the message to the list
        receivedMessages.add(message);
    }

    // Method to get all received messages
    public List<String> getReceivedMessages() {
        return receivedMessages;
    }
}