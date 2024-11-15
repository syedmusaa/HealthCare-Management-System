package com.HealthCareManagement.HealthHub.Entity;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
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
@Table(name = "appointments")
public class Appointment {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "patient_id", nullable = false)
	    private Patient patient;

	    @Column(nullable = false)
	    private LocalDateTime appointmentDateTime;

	    @Column(nullable = false)
	    private String doctorName;

	    @Column(nullable = false)
	    private String appointmentType;

	    @Column
	    private String notes;

	    @Column(nullable = false)
	    private String status;

	    // Getters and setters
	}
