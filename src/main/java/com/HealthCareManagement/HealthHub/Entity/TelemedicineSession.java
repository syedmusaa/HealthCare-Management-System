package com.HealthCareManagement.HealthHub.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "telemedicine_sessions")
public class TelemedicineSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    private Date sessionDate;
    
    private String sessionStatus;
    
    private String videoRecordingUrl;
    
    private String chatHistory;
    
//  @ManyToOne
//  @JoinColumn(name = "doctor_id", nullable = false)
//  private Doctor doctor;

    // Constructors, getters, and setters

}