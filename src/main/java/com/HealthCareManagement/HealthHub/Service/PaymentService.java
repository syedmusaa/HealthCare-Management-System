package com.HealthCareManagement.HealthHub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareManagement.HealthHub.Entity.Payment;
import com.HealthCareManagement.HealthHub.Repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
    private PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    
    
    

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
    }
    
    

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
    
    

    public Payment updatePayment(Long id, Payment payment) {
        Payment existingPayment = getPaymentById(id);
        
        existingPayment.setInvoice(payment.getInvoice());
        
        existingPayment.setAmount(payment.getAmount());
        
        existingPayment.setPaymentDateTime(payment.getPaymentDateTime());
        
        existingPayment.setPaymentMethod(payment.getPaymentMethod());
        
        existingPayment.setTransactionId(payment.getTransactionId());
        
        existingPayment.setStatus(payment.getStatus());
        
        return paymentRepository.save(existingPayment);
    }

    
    
    
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
    
    
}
