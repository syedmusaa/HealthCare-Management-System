package com.HealthCareManagement.HealthHub.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HealthCareManagement.HealthHub.Entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	Optional<Patient> findByEmail(String email);
}
