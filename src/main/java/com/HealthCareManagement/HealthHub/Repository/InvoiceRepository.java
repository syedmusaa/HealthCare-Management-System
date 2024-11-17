package com.HealthCareManagement.HealthHub.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HealthCareManagement.HealthHub.Entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

	List<Invoice> findByPatientId(Long patientId);

}
