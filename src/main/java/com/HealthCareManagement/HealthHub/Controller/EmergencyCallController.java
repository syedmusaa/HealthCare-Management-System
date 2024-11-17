package com.HealthCareManagement.HealthHub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HealthCareManagement.HealthHub.Entity.EmergencyCall;
import com.HealthCareManagement.HealthHub.Service.EmergencyCallService;

@RestController
@RequestMapping("/emergency-calls")
public class EmergencyCallController {

	@Autowired
    private EmergencyCallService emergencyCallService;

//    @Autowired
//    public EmergencyCallController(EmergencyCallService emergencyCallService) {
//        this.emergencyCallService = emergencyCallService;
//    }

    @GetMapping
    public List<EmergencyCall> getAllEmergencyCalls() {
        return emergencyCallService.getAllEmergencyCalls();
    }

    
    
    
    @GetMapping("/{id}")
    public ResponseEntity<EmergencyCall> getEmergencyCallById(@PathVariable Long id) {
        return emergencyCallService.getEmergencyCallById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    
    
    
    
    @GetMapping("/patient/{patientId}")
    public List<EmergencyCall> getEmergencyCallsByPatientId(@PathVariable Long patientId) {
        return emergencyCallService.getEmergencyCallsByPatientId(patientId);
    }

    
    
    
    
    
    @GetMapping("/status/{status}")
    public List<EmergencyCall> getEmergencyCallsByStatus(@PathVariable String status) {
        return emergencyCallService.getEmergencyCallsByStatus(status);
    }

    
    
    
    
    @PostMapping("/patient/{patientId}")
    public EmergencyCall createEmergencyCall(@PathVariable Long patientId, @RequestParam String emergencyType) {
        return emergencyCallService.createEmergencyCall(patientId, emergencyType);
    }

    
    
    
    
    @PutMapping("/{id}")
    public ResponseEntity<EmergencyCall> updateEmergencyCall(@PathVariable Long id, @RequestBody EmergencyCall emergencyCallDetails) {
        EmergencyCall updatedEmergencyCall = emergencyCallService.updateEmergencyCall(id, emergencyCallDetails);
        return ResponseEntity.ok(updatedEmergencyCall);
    }

    
    
    
    
    @PutMapping("/{id}/assign")
    public ResponseEntity<EmergencyCall> assignStaffMember(@PathVariable Long id, @RequestParam String staffMember) {
        EmergencyCall updatedEmergencyCall = emergencyCallService.assignStaffMember(id, staffMember);
        return ResponseEntity.ok(updatedEmergencyCall);
    }
    
    
    
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmergencyCall(@PathVariable Long id) {
        emergencyCallService.deleteEmergencyCall(id);
        return ResponseEntity.ok().build();
    }

    
    
//    @DeleteMapping("/{id}")
//    public ResponseEntity<EmergencyCall> deleteEmergencyCall(@PathVariable Long id) {
//        emergencyCallService.deleteEmergencyCall(id);
//        return ResponseEntity.ok().build();
//    }




}
