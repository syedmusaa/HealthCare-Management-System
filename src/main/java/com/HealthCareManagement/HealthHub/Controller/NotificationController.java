package com.HealthCareManagement.HealthHub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.HealthCareManagement.HealthHub.Entity.Notification;
import com.HealthCareManagement.HealthHub.Service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

//    @GetMapping
//    public ResponseEntity<List<String>> getNotifications() {
//        List<String> notifications = notificationService.getNotifications();
//        return ResponseEntity.ok(notifications);
//    }

    @PostMapping("/create")
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        return ResponseEntity.ok(notificationService.saveNotification(notification));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotification(@PathVariable Long id) {
        return ResponseEntity.ok(notificationService.getNotificationById(id));
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable Long id, @RequestBody Notification notification) {
        return ResponseEntity.ok(notificationService.updateNotification(id, notification));
    }
    
    @PostMapping("/clear")
    public ResponseEntity<Void> clearNotifications() {
        notificationService.clearNotifications();
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/send")
    public ResponseEntity<Void> sendNotification(@RequestBody Notification notification) {
        notificationService.sendNotification(notification);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/medication-reminder")
    public ResponseEntity<Void> sendMedicationReminder(@RequestParam Long patientId, @RequestParam String medicationName) {
        notificationService.sendMedicationReminder(patientId, medicationName);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/appointment-reminder")
    public ResponseEntity<Void> sendAppointmentReminder(@RequestParam Long patientId, @RequestParam String appointmentType, @RequestParam String dateTime) {
        notificationService.sendAppointmentReminder(patientId, appointmentType, dateTime);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/insurance-update")
    public ResponseEntity<Void> sendInsuranceUpdateNotification(@RequestParam Long patientId, @RequestParam String updateType) {
        notificationService.sendInsuranceUpdateNotification(patientId, updateType);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/emergency")
    public ResponseEntity<Void> sendEmergencyNotification(@RequestParam String emergencyType, @RequestParam String location) {
        notificationService.sendEmergencyNotification(emergencyType, location);
        return ResponseEntity.ok().build();
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.ok().build();
    }
 
}

