package com.HealthCareManagement.HealthHub.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HealthCareManagement.HealthHub.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByPatientId(Long patientId);
    
    List<Payment> findByInvoiceId(Long patientId);
    
    List<Payment> findByStatus(String status);
    
    List<Payment> findByPaymentMethod(String paymentMethod);

}
