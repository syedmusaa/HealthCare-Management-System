package com.HealthCareManagement.HealthHub.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareManagement.HealthHub.Entity.Invoice;
import com.HealthCareManagement.HealthHub.Entity.Patient;
import com.HealthCareManagement.HealthHub.Repository.InvoiceRepository;
import com.HealthCareManagement.HealthHub.Repository.PatientRepository;

@Service
public class InvoiceService {
	
	@Autowired
    private InvoiceRepository invoiceRepository;
	
	@Autowired
    private PatientRepository patientRepository;
	
	

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

	public Invoice createInvoice(Invoice invoice, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientId));
        invoice.setPatient(patient);

        // Perform insurance eligibility check and claim submission here
        // For demonstration, we'll just set some example values
        invoice.setInsuranceCoverage(invoice.getTotalAmount().multiply(new BigDecimal("0.8")));
        invoice.setPatientResponsibility(invoice.getTotalAmount().subtract(invoice.getInsuranceCoverage()));

        // Check for Ayushman Card
        if (invoice.isAyushmanCard()) {
        	invoice.setPatientResponsibility(BigDecimal.ZERO);
        }

        return invoiceRepository.save(invoice);
    }
    
    
    
    
    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
        		.orElseThrow(() -> new RuntimeException("Invoice not found"));
    }

    
    
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    
    
    public Invoice updateInvoice(Long id, Invoice invoice) {
        Invoice existingInvoice = getInvoiceById(id);
        
        existingInvoice.setPatient(invoice.getPatient());
        
        existingInvoice.setInvoiceDate(invoice.getInvoiceDate());
        
        existingInvoice.setTotalAmount(invoice.getTotalAmount());
        
        existingInvoice.setInsuranceProvider(invoice.getInsuranceProvider());
        
        existingInvoice.setInsuranceCoverage(invoice.getInsuranceCoverage());
        
        existingInvoice.setPatientResponsibility(invoice.getPatientResponsibility());
        
        existingInvoice.setAyushmanCard(invoice.isAyushmanCard());
        
        existingInvoice.setPaymentStatus(invoice.getPaymentStatus());
        
        existingInvoice.setDescription(invoice.getDescription());
        
        return invoiceRepository.save(existingInvoice);
    }

    
    
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
    
    
}

