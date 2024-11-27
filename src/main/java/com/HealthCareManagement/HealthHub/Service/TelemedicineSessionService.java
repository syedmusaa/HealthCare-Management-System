package com.HealthCareManagement.HealthHub.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareManagement.HealthHub.Entity.TelemedicineSession;
import com.HealthCareManagement.HealthHub.Repository.TelemedicineSessionRepository;

@Service
public class TelemedicineSessionService {

	@Autowired
    private TelemedicineSessionRepository telemedicineSessionRepository;

//    @Autowired
//    public TelemedicineSessionService(TelemedicineSessionRepository telemedicineSessionRepository) {
//        this.telemedicineSessionRepository = telemedicineSessionRepository;
//    }

    public List<TelemedicineSession> getAllTelemedicineSessions() {
        return telemedicineSessionRepository.findAll();
    }

    public Optional<TelemedicineSession> getTelemedicineSessionById(Long id) {
        return telemedicineSessionRepository.findById(id);
    }

    public List<TelemedicineSession> getTelemedicineSessionsByPatientId(Long patientId) {
        return telemedicineSessionRepository.findByPatientId(patientId);
    }

//    public List<TelemedicineSession> getTelemedicineSessionsByDoctorId(Long doctorId) {
//        return telemedicineSessionRepository.findByDoctorId(doctorId);
//    }

    public List<TelemedicineSession> getTelemedicineSessionsByStatus(String status) {
        return telemedicineSessionRepository.findBySessionStatus(status);
    }

    public TelemedicineSession createTelemedicineSession(TelemedicineSession telemedicineSession) {
        return telemedicineSessionRepository.save(telemedicineSession);
    }

    public TelemedicineSession updateTelemedicineSession(Long id, TelemedicineSession telemedicineSessionDetails) {
        
    	TelemedicineSession telemedicineSession = telemedicineSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Telemedicine Session not found with id: " + id));

        
        telemedicineSession.setPatient(telemedicineSessionDetails.getPatient());
      
//      telemedicineSession.setDoctor(telemedicineSessionDetails.getDoctor());
        
        telemedicineSession.setSessionDate(telemedicineSessionDetails.getSessionDate());
        
        telemedicineSession.setSessionStatus(telemedicineSessionDetails.getSessionStatus());
        
        telemedicineSession.setVideoRecordingUrl(telemedicineSessionDetails.getVideoRecordingUrl());
        
        telemedicineSession.setChatHistory(telemedicineSessionDetails.getChatHistory());

        return telemedicineSessionRepository.save(telemedicineSession);
    }


    public TelemedicineSession updateSessionStatus(Long id, String newStatus) {
        TelemedicineSession telemedicineSession = telemedicineSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Telemedicine Session not found with id: " + id));

        telemedicineSession.setSessionStatus(newStatus);
        return telemedicineSessionRepository.save(telemedicineSession);
    }

    public TelemedicineSession addChatHistory(Long id, String chatMessage) {
        TelemedicineSession telemedicineSession = telemedicineSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Telemedicine Session not found with id: " + id));

        String currentChatHistory = telemedicineSession.getChatHistory();
        String updatedChatHistory = currentChatHistory == null ? chatMessage : currentChatHistory + "\\n" + chatMessage;
        telemedicineSession.setChatHistory(updatedChatHistory);

        return telemedicineSessionRepository.save(telemedicineSession);
    }
    
    public void deleteTelemedicineSession(Long id) {
        telemedicineSessionRepository.deleteById(id);
    }
}

