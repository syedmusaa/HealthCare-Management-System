package com.HealthCareManagement.HealthHub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HealthCareManagement.HealthHub.Entity.InsuranceProvider;
import com.HealthCareManagement.HealthHub.Service.InsuranceProviderService;

@RestController
@RequestMapping("/insurance-providers")
public class InsuranceProviderController {

	@Autowired
    private  InsuranceProviderService insuranceProviderService;

//    @Autowired
//    public InsuranceProviderController(InsuranceProviderService insuranceProviderService) {
//        this.insuranceProviderService = insuranceProviderService;
//    }

    @GetMapping
    public List<InsuranceProvider> getAllInsuranceProviders() {
        return insuranceProviderService.getAllInsuranceProviders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsuranceProvider> getInsuranceProviderById(@PathVariable Long id) {
        return insuranceProviderService.getInsuranceProviderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add-Insurance-Provider")
    public InsuranceProvider createInsuranceProvider(@RequestBody InsuranceProvider insuranceProvider) {
        return insuranceProviderService.createInsuranceProvider(insuranceProvider);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsuranceProvider> updateInsuranceProvider(@PathVariable Long id, @RequestBody InsuranceProvider insuranceProviderDetails) {
        InsuranceProvider updatedInsuranceProvider = insuranceProviderService.updateInsuranceProvider(id, insuranceProviderDetails);
        return ResponseEntity.ok(updatedInsuranceProvider);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteInsuranceProvider(@PathVariable Long id) {
//        insuranceProviderService.deleteInsuranceProvider(id);
//        return ResponseEntity.ok().build();
//    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<InsuranceProvider> deleteInsuranceProvider(@PathVariable Long id) {
        insuranceProviderService.deleteInsuranceProvider(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/check-eligibility")
    public ResponseEntity<Boolean> checkInsuranceEligibility(@RequestParam String policyNumber, @RequestParam String providerName) {
        boolean isEligible = insuranceProviderService.checkInsuranceEligibility(policyNumber, providerName);
        return ResponseEntity.ok(isEligible);
    }

    @PostMapping("/submit-claim")
    public ResponseEntity<Boolean> submitInsuranceClaim(@RequestParam String policyNumber, @RequestParam String providerName, @RequestParam double amount) {
        boolean isSubmitted = insuranceProviderService.submitInsuranceClaim(policyNumber, providerName, amount);
        return ResponseEntity.ok(isSubmitted);
    }
}