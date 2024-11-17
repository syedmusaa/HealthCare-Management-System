package com.HealthCareManagement.HealthHub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareManagement.HealthHub.Entity.Patient;
import com.HealthCareManagement.HealthHub.Repository.PatientRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PatientService {

	
    @Autowired
    private PatientRepository patientRepository;

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
    
    
    
    

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
        		.orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    
    
    
    
    
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    
    
    
    
    
    public Patient updatePatient(Long id, Patient patient) {
        Patient existingPatient = getPatientById(id);
        
        existingPatient.setFirstName(patient.getFirstName());
        
        existingPatient.setLastName(patient.getLastName());
        
        existingPatient.setGender(patient.getGender());
        
        existingPatient.setEmail(patient.getEmail());
        
        existingPatient.setDateOfBirth(patient.getDateOfBirth());
        
        existingPatient.setPhoneNumber(patient.getPhoneNumber());
        
//        existingPatient.setAppointments(patient.getAppointments());
        
//        existingPatient.setMedicalRecords(patient.getMedicalRecords());
        
        return patientRepository.save(existingPatient);
    }

    
    
    
    public void deletePatient(Long id) {
    	 Patient patient = patientRepository.findById(id)
    	  .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + id));
        patientRepository.delete(patient);
    }
    
    
}

