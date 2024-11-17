package com.HealthCareManagement.HealthHub.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HealthCareManagement.HealthHub.Entity.EmergencyCall;

@Repository
public interface EmergencyCallRepository extends JpaRepository<EmergencyCall, Long> {
	
    List<EmergencyCall> findByPatientId(Long patientId);
    
    List<EmergencyCall> findByStatus(String status);
}

