package com.HealthCareManagement.HealthHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HealthCareManagement.HealthHub.Entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
