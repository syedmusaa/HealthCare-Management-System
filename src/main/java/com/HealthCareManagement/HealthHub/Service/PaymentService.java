package com.HealthCareManagement.HealthHub.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareManagement.HealthHub.Entity.Payment;
import com.HealthCareManagement.HealthHub.Repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
    private PaymentRepository paymentRepository;

	public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> getPaymentsByPatientId(Long patientId) {
        return paymentRepository.findByPatientId(patientId);
    }
    
    public List<Payment> getPaymentsByInvoiceId(Long invoiceId) {
        return paymentRepository.findByInvoiceId(invoiceId);
    }

    public List<Payment> getPaymentsByStatus(String status) {
        return paymentRepository.findByStatus(status);
    }

    public List<Payment> getPaymentsByPaymentMethod(String paymentMethod) {
        return paymentRepository.findByPaymentMethod(paymentMethod);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment paymentDetails) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));

        payment.setPatient(paymentDetails.getPatient());
        
        payment.setAmount(paymentDetails.getAmount());
        
        payment.setPaymentDateTime(paymentDetails.getPaymentDateTime());
        
        payment.setPaymentMethod(paymentDetails.getPaymentMethod());
        
        payment.setTransactionId(paymentDetails.getTransactionId());
        
        payment.setStatus(paymentDetails.getStatus());

        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    
    public Payment updatePaymentStatus(Long id, String newStatus) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));

        payment.setStatus(newStatus);
        return paymentRepository.save(payment);
    }
}

	
	
	
//    public Payment savePayment(Payment payment) {
//        return paymentRepository.save(payment);
//    }
//    
//    
//    
//
//    public Payment getPaymentById(Long id) {
//        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
//    }
//    
//    
//
//    public List<Payment> getAllPayments() {
//        return paymentRepository.findAll();
//    }
//    
//    
//
//    public Payment updatePayment(Long id, Payment payment) {
//        Payment existingPayment = getPaymentById(id);
//        
//        existingPayment.setInvoice(payment.getInvoice());
//        
//        existingPayment.setAmount(payment.getAmount());
//        
//        existingPayment.setPaymentDateTime(payment.getPaymentDateTime());
//        
//        existingPayment.setPaymentMethod(payment.getPaymentMethod());
//        
//        existingPayment.setTransactionId(payment.getTransactionId());
//        
//        existingPayment.setStatus(payment.getStatus());
//        
//        return paymentRepository.save(existingPayment);
//    }
//
//    
//    
//    
//    public void deletePayment(Long id) {
//        paymentRepository.deleteById(id);
//    }
//    }
