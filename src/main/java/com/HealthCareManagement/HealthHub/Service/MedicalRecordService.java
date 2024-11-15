package com.HealthCareManagement.HealthHub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareManagement.HealthHub.Entity.MedicalRecord;
import com.HealthCareManagement.HealthHub.Repository.MedicalRecordRepository;

@Service
public class MedicalRecordService {

	@Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    public MedicalRecord getMedicalRecordById(Long id) {
        return medicalRecordRepository.findById(id)
        		.orElseThrow(() -> new RuntimeException("Medical Record not found"));
    }

    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();
    }

    public MedicalRecord updateMedicalRecord(Long id, MedicalRecord medicalRecord) {
        MedicalRecord existingMedicalRecord = getMedicalRecordById(id);
        
        existingMedicalRecord.setPatient(medicalRecord.getPatient());

        existingMedicalRecord.setRecordDate(medicalRecord.getRecordDate());
        
        existingMedicalRecord.setDiagnosis(medicalRecord.getDiagnosis());
        
        existingMedicalRecord.setTreatment(medicalRecord.getTreatment());
        
        existingMedicalRecord.setPrescription(medicalRecord.getPrescription());
        
        existingMedicalRecord.setNotes(medicalRecord.getNotes());
        
        return medicalRecordRepository.save(existingMedicalRecord);
    }

    public void deleteMedicalRecord(Long id) {
        medicalRecordRepository.deleteById(id);
    }
}

