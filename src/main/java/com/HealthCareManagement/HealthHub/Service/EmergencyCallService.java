package com.HealthCareManagement.HealthHub.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareManagement.HealthHub.Entity.EmergencyCall;
import com.HealthCareManagement.HealthHub.Entity.Patient;
import com.HealthCareManagement.HealthHub.Repository.EmergencyCallRepository;
import com.HealthCareManagement.HealthHub.Repository.PatientRepository;

@Service
public class EmergencyCallService {

	@Autowired
    private EmergencyCallRepository emergencyCallRepository;
	
    private PatientRepository patientRepository;

//    @Autowired
//    public EmergencyCallService(EmergencyCallRepository emergencyCallRepository, PatientRepository patientRepository) {
//        this.emergencyCallRepository = emergencyCallRepository;
//        this.patientRepository = patientRepository;
//    }

    public List<EmergencyCall> getAllEmergencyCalls() {
        return emergencyCallRepository.findAll();
    }

    
    
    
    public Optional<EmergencyCall> getEmergencyCallById(Long id) {
        return emergencyCallRepository.findById(id);
    }

    
    
    
    
    public List<EmergencyCall> getEmergencyCallsByPatientId(Long patientId) {
        return emergencyCallRepository.findByPatientId(patientId);
    }

    
    
    
    
    public List<EmergencyCall> getEmergencyCallsByStatus(String status) {
        return emergencyCallRepository.findByStatus(status);
    }

    
    
    
    
    
    public EmergencyCall createEmergencyCall(Long patientId, String emergencyType) {
    	
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientId));

        EmergencyCall emergencyCall = new EmergencyCall();
        
        emergencyCall.setPatient(patient);
        
        emergencyCall.setCallTime(new Date());
        
        emergencyCall.setEmergencyType(emergencyType);
        
        emergencyCall.setStatus("PENDING");

        return emergencyCallRepository.save(emergencyCall);
    }
    
    
    
    

    public EmergencyCall updateEmergencyCall(Long id, EmergencyCall emergencyCallDetails) {
    	
        EmergencyCall emergencyCall = emergencyCallRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emergency Call not found with id: " + id));

        emergencyCall.setEmergencyType(emergencyCallDetails.getEmergencyType());
        
        emergencyCall.setStatus(emergencyCallDetails.getStatus());
        
        emergencyCall.setAssignedStaffMember(emergencyCallDetails.getAssignedStaffMember());

        return emergencyCallRepository.save(emergencyCall);
    }

    
    
    
    
    public void deleteEmergencyCall(Long id) {
        emergencyCallRepository.deleteById(id);
    }

    
    
    
    
    
    public EmergencyCall assignStaffMember(Long id, String staffMember) {
    	
        EmergencyCall emergencyCall = emergencyCallRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emergency Call not found with id: " + id));

        emergencyCall.setAssignedStaffMember(staffMember);
        
        emergencyCall.setStatus("ASSIGNED");

        return emergencyCallRepository.save(emergencyCall);
    }
}

