package com.HealthCareManagement.HealthHub.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareManagement.HealthHub.Entity.Notification;
import com.HealthCareManagement.HealthHub.Repository.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
    private NotificationRepository notificationRepository;

	private List<String> notifications = new ArrayList<>();

    public void addNotification(String message) {
        notifications.add(message);
    }

    public Notification saveNotification(Notification notification) {
      return notificationRepository.save(notification);
    }
    
//    public List<String> getNotifications() {
//        return new ArrayList<>(notifications);
//    }
    
    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id)
  		.orElseThrow(() -> new RuntimeException("Notification not found"));
     }
    

    public Notification updateNotification(Long id, Notification notification) {
      Notification existingNotification = getNotificationById(id);
      
      existingNotification.setPatient(notification.getPatient());
      
      existingNotification.setMessage(notification.getMessage());
      
      existingNotification.setSentDateTime(notification.getSentDateTime());
      
      existingNotification.setNotificationType(notification.getNotificationType());
      
      existingNotification.setRecipient(notification.getRecipient());
      
      existingNotification.setRead(notification.isRead());
      
      return notificationRepository.save(existingNotification);
      
    }
    
    
    
    public void clearNotifications() {
        notifications.clear();
    }
    
    
    
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    

    public void sendNotification(Notification notification) {

        // For now, we'll just save the notification to the database
    	
        if (notification == null || notification.getNotificationType() == null || notification.getMessage() == null) {
            throw new IllegalArgumentException("Notification details are incomplete.");
        }

        // Simulated logic for sending notifications
        switch (notification.getNotificationType().toUpperCase()) {
        
            case "EMAIL":
                sendEmail(notification);
                break;

            case "SMS":
                sendSMS(notification);
                break;

            case "PUSH":
                sendPushNotification(notification);
                break;

            default:
                System.out.println("Unsupported notification type: " + notification.getNotificationType());
                return;
        }

        // Save notification to the database
        saveNotification(notification);

        System.out.println("Notification sent: " + notification.getMessage());
    }

    private void sendEmail(Notification notification) {
        // Simulate sending email
        System.out.println("Sending email to: " + notification.getRecipient() + " with message: " + notification.getMessage());
    }

    private void sendSMS(Notification notification) {
        // Simulate sending SMS
        System.out.println("Sending SMS to: " + notification.getRecipient() + " with message: " + notification.getMessage());
    }

    private void sendPushNotification(Notification notification) {
        // Simulate sending a push notification
        System.out.println("Sending push notification to: " + notification.getRecipient() + " with message: " + notification.getMessage());
    }

//    @SuppressWarnings("unused")
//	private void addNotification(Notification notification) {
//        // Simulate saving the notification to the database
//        System.out.println("Saving notification to the database: " + notification);
//        
//        addNotification(notification);
//        System.out.println("Notification sent: " + notification.getMessage());
//    }

    
    
    
    public void sendMedicationReminder(Long patientId, String medicationName) {
        String message = "Reminder: It's time to take your " + medicationName + ".";
        addNotification(message);
        // In a real-world scenario, you would send this notification to the patient
        // via email, SMS, or push notification.
    }

    
    
    
    public void sendAppointmentReminder(Long patientId, String appointmentType, String dateTime) {
        String message = "Reminder: You have a " + appointmentType + " appointment scheduled for " + dateTime + ".";
        addNotification(message);
        // In a real-world scenario, you would send this notification to the patient
        // via email, SMS, or push notification.
    }

    
    
    
    public void sendInsuranceUpdateNotification(Long patientId, String updateType) {
        String message = "Insurance Update: Your insurance " + updateType + " has been processed.";
        addNotification(message);
        // In a real-world scenario, you would send this notification to the patient
        // via email, SMS, or push notification.
    }

    
    
    public void sendEmergencyNotification(String emergencyType, String location) {
        String message = "EMERGENCY ALERT: " + emergencyType + " reported at " + location + ".";
        addNotification(message);
        // In a real-world scenario, you would send this notification to all relevant staff
        // via email, SMS, or push notification.
    }
    
    
    public void deleteNotification(Long id) {
      notificationRepository.deleteById(id);
    }
    
 }
