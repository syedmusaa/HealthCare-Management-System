package com.HealthCareManagement.HealthHub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareManagement.HealthHub.Entity.Invoice;
import com.HealthCareManagement.HealthHub.Repository.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
    private InvoiceRepository invoiceRepository;
	
	

    public Invoice saveInvoice(Invoice invoice) {
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
        
        existingInvoice.setPaymentStatus(invoice.getPaymentStatus());
        
        existingInvoice.setDescription(invoice.getDescription());
        
        return invoiceRepository.save(existingInvoice);
    }

    
    
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
    
    
}

