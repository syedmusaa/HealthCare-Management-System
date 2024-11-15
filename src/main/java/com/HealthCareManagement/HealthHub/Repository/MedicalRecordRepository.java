package com.HealthCareManagement.HealthHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HealthCareManagement.HealthHub.Entity.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {

}
