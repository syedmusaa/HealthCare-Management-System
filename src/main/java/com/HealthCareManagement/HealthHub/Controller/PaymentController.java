package com.HealthCareManagement.HealthHub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.HealthCareManagement.HealthHub.Entity.Payment;
import com.HealthCareManagement.HealthHub.Service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/patient/{patientId}")
    public List<Payment> getPaymentsByPatientId(@PathVariable Long patientId) {
        return paymentService.getPaymentsByPatientId(patientId);
    }
    
    @GetMapping("/invoice/{invoiceId}")
    public List<Payment> getPaymentsByInvoiceId(@PathVariable Long invoiceId) {
        return paymentService.getPaymentsByInvoiceId(invoiceId);
    }

    @GetMapping("/status/{status}")
    public List<Payment> getPaymentsByStatus(@PathVariable String status) {
        return paymentService.getPaymentsByStatus(status);
    }

    @GetMapping("/method/{paymentMethod}")
    public List<Payment> getPaymentsByPaymentMethod(@PathVariable String paymentMethod) {
        return paymentService.getPaymentsByPaymentMethod(paymentMethod);
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment paymentDetails) {
        Payment updatedPayment = paymentService.updatePayment(id, paymentDetails);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Payment> updatePaymentStatus(@PathVariable Long id, @RequestParam String newStatus) {
        Payment updatedPayment = paymentService.updatePaymentStatus(id, newStatus);
        return ResponseEntity.ok(updatedPayment);
    }
}

    
    
    
    
//    @PostMapping
//    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
//        return ResponseEntity.ok(paymentService.savePayment(payment));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Payment> getPayment(@PathVariable Long id) {
//        return ResponseEntity.ok(paymentService.getPaymentById(id));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Payment>> getAllPayments() {
//        return ResponseEntity.ok(paymentService.getAllPayments());
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
//        return ResponseEntity.ok(paymentService.updatePayment(id, payment));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
//        paymentService.deletePayment(id);
//        return ResponseEntity.ok().build();
//    }
//}

