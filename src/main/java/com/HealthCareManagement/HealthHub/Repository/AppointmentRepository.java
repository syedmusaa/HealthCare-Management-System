package com.HealthCareManagement.HealthHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HealthCareManagement.HealthHub.Entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
