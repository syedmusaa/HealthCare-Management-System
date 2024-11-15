package com.HealthCareManagement.HealthHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HealthCareManagement.HealthHub.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
