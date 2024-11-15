package com.HealthCareManagement.HealthHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HealthCareManagement.HealthHub.Entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
