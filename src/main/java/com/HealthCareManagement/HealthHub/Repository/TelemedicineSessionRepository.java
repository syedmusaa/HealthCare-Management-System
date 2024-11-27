package com.HealthCareManagement.HealthHub.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HealthCareManagement.HealthHub.Entity.TelemedicineSession;

@Repository
public interface TelemedicineSessionRepository extends JpaRepository<TelemedicineSession, Long> {

	List<TelemedicineSession> findByPatientId(Long patientId);
    
//	List<TelemedicineSession> findByDoctorId(Long doctorId);
    
	List<TelemedicineSession> findBySessionStatus(String sessionStatus);
}

