package com.HealthCareManagement.HealthHub.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false)
    private LocalDate invoiceDate;

    @Column(nullable = false)
    private BigDecimal totalAmount;

    @Column(nullable = true)
    private String insuranceProvider;
    
    @Column(nullable = true)
    private String insurancePolicyNumber;

    @Column(nullable = true)
    private BigDecimal insuranceCoverage;
    
    @Column(nullable = true)
    private BigDecimal patientResponsibility;
    
    @Column(nullable = true)
    private boolean isAyushmanCard;


    @Column(nullable = false)
    private String paymentStatus;

    @Column
    private String description;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<Payment> payments;

    // Getters and setters
}
