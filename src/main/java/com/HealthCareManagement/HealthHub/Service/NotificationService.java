package com.HealthCareManagement.HealthHub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareManagement.HealthHub.Entity.Notification;
import com.HealthCareManagement.HealthHub.Repository.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
    private NotificationRepository notificationRepository;

    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }
    
    
    
    

    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id)
        		.orElseThrow(() -> new RuntimeException("Notification not found"));
    }

    
    
    
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    
    
    
    
    
    public Notification updateNotification(Long id, Notification notification) {
        Notification existingNotification = getNotificationById(id);
        
        existingNotification.setPatient(notification.getPatient());
        
        existingNotification.setMessage(notification.getMessage());
        
        existingNotification.setSentDateTime(notification.getSentDateTime());
        
        existingNotification.setNotificationType(notification.getNotificationType());
        
        existingNotification.setRead(notification.isRead());
        
        return notificationRepository.save(existingNotification);
    }

    
    
    

    public void sendNotification(Notification notification) {
        // Implement the logic to send the notification (e.g., email, SMS, push notification)
        // For now, we'll just save the notification to the database
        saveNotification(notification);
        System.out.println("Notification sent: " + notification.getMessage());
    }
    
    
    
    
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
