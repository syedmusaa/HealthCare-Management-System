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

import com.HealthCareManagement.HealthHub.Entity.TelemedicineSession;
import com.HealthCareManagement.HealthHub.Service.TelemedicineSessionService;

@RestController
@RequestMapping("/telemedicine-sessions")
public class TelemedicineSessionController {

	@Autowired
    private TelemedicineSessionService telemedicineSessionService;

//    @Autowired
//    public TelemedicineSessionController(TelemedicineSessionService telemedicineSessionService) {
//        this.telemedicineSessionService = telemedicineSessionService;
//    }

    @GetMapping
    public List<TelemedicineSession> getAllTelemedicineSessions() {
        return telemedicineSessionService.getAllTelemedicineSessions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelemedicineSession> getTelemedicineSessionById(@PathVariable Long id) {
        return telemedicineSessionService.getTelemedicineSessionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/patient/{patientId}")
    public List<TelemedicineSession> getTelemedicineSessionsByPatientId(@PathVariable Long patientId) {
        return telemedicineSessionService.getTelemedicineSessionsByPatientId(patientId);
    }

//    @GetMapping("/doctor/{doctorId}")
//    public List<TelemedicineSession> getTelemedicineSessionsByDoctorId(@PathVariable Long doctorId) {
//        return telemedicineSessionService.getTelemedicineSessionsByDoctorId(doctorId);
//    }

    @GetMapping("/status/{status}")
    public List<TelemedicineSession> getTelemedicineSessionsByStatus(@PathVariable String status) {
        return telemedicineSessionService.getTelemedicineSessionsByStatus(status);
    }

    @PostMapping
    public TelemedicineSession createTelemedicineSession(@RequestBody TelemedicineSession telemedicineSession) {
        return telemedicineSessionService.createTelemedicineSession(telemedicineSession);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelemedicineSession> updateTelemedicineSession(@PathVariable Long id, @RequestBody TelemedicineSession telemedicineSessionDetails) {
        TelemedicineSession updatedTelemedicineSession = telemedicineSessionService.updateTelemedicineSession(id, telemedicineSessionDetails);
        return ResponseEntity.ok(updatedTelemedicineSession);
    }


    @PutMapping("/{id}/status")
    public ResponseEntity<TelemedicineSession> updateSessionStatus(@PathVariable Long id, @RequestParam String newStatus) {
        TelemedicineSession updatedTelemedicineSession = telemedicineSessionService.updateSessionStatus(id, newStatus);
        return ResponseEntity.ok(updatedTelemedicineSession);
    }

    @PostMapping("/{id}/chat")
    public ResponseEntity<TelemedicineSession> addChatMessage(@PathVariable Long id, @RequestBody String chatMessage) {
        TelemedicineSession updatedTelemedicineSession = telemedicineSessionService.addChatHistory(id, chatMessage);
        return ResponseEntity.ok(updatedTelemedicineSession);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelemedicineSession(@PathVariable Long id) {
        telemedicineSessionService.deleteTelemedicineSession(id);
        return ResponseEntity.ok().build();
    }
    
    
//    @DeleteMapping("/{id}")
//    public ResponseEntity<TelemedicineSession> deleteTelemedicineSession(@PathVariable Long id) {
//        telemedicineSessionService.deleteTelemedicineSession(id);
//        return ResponseEntity.ok().build();
//    }
}

