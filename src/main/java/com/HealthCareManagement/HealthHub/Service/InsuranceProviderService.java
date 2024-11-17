package com.HealthCareManagement.HealthHub.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareManagement.HealthHub.Entity.InsuranceProvider;
import com.HealthCareManagement.HealthHub.Repository.InsuranceProviderRepository;

@Service
public class InsuranceProviderService {

	@Autowired
    private  InsuranceProviderRepository insuranceProviderRepository;

	
	
//    @Autowired
//    public InsuranceProviderService(InsuranceProviderRepository insuranceProviderRepository) {
//        this.insuranceProviderRepository = insuranceProviderRepository;
//    }
	
	
	
	

    public List<InsuranceProvider> getAllInsuranceProviders() {
        return insuranceProviderRepository.findAll();
    }
    
    
    
    

    public Optional<InsuranceProvider> getInsuranceProviderById(Long id) {
        return insuranceProviderRepository.findById(id);
    }
    
    
    
    

    public InsuranceProvider getInsuranceProviderByName(String name) {
        return insuranceProviderRepository.findByName(name);
    }
    
    
    
    

    public InsuranceProvider createInsuranceProvider(InsuranceProvider insuranceProvider) {
        return insuranceProviderRepository.save(insuranceProvider);
    }
    
    
    
    

    public InsuranceProvider updateInsuranceProvider(Long id, InsuranceProvider insuranceProviderDetails) {
        InsuranceProvider insuranceProvider = insuranceProviderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance Provider not found with id: " + id));

        insuranceProvider.setName(insuranceProviderDetails.getName());
        
        insuranceProvider.setContactNumber(insuranceProviderDetails.getContactNumber());
        
        insuranceProvider.setEmail(insuranceProviderDetails.getEmail());
        
        insuranceProvider.setApiEndpoint(insuranceProviderDetails.getApiEndpoint());

        return insuranceProviderRepository.save(insuranceProvider);
    }
    
    
    
    

    public void deleteInsuranceProvider(Long id) {
        insuranceProviderRepository.deleteById(id);
    }
    
    
    
    

    // Add methods for insurance eligibility check and claim submission
    public boolean checkInsuranceEligibility(String policyNumber, String providerName) {
    	// Check if providerName is valid
    	List<String> supportedProviders = Arrays.asList("ProviderA", "ProviderB", "ProviderC", "ProviderD", "ProviderE", "ProviderF", "ProviderG");

        if (!supportedProviders.contains(providerName)) {
            System.out.println("Unsupported insurance provider: " + providerName);
            return false;
        }

        // Validate policy number (e.g., check length and format)
        if (policyNumber == null || !policyNumber.matches("^[A-Z]{2}-\\d{6}$")) {
            System.out.println("Invalid policy number format. Expected format: XX-123456");
            return false;
        }

        // Simulate eligibility check (e.g., verify active status or valid dates)
        if ("INACTIVE".equals(policyNumber.substring(3, 6))) {
            System.out.println("Policy is inactive or invalid.");
            return false;
        }

        // If all checks pass, the insurance is eligible
        System.out.println("Insurance is eligible.");
        
        return true;
    }
    
    
    

    public boolean submitInsuranceClaim(String policyNumber, String providerName, double amount) {
    	// List of supported insurance providers
        List<String> supportedProviders = Arrays.asList("ProviderA", "ProviderB", "ProviderC");

        // Validate policy number
        if (policyNumber == null || !policyNumber.matches("^[A-Z]{2}-\\d{6}$")) {
            System.out.println("Invalid policy number format. Expected format: XX-123456");
            return false;
        }

        // Validate provider name
        if (!supportedProviders.contains(providerName)) {
            System.out.println("Unsupported insurance provider: " + providerName);
            return false;
        }

        // Validate claim amount
        if (amount <= 0) {
            System.out.println("Invalid claim amount. Amount must be greater than 0.");
            return false;
        }

        // Simulate policy check (e.g., verify if the policy is active and claimable)
        if ("INACTIVE".equals(policyNumber.substring(3, 6))) {
            System.out.println("Policy is inactive or invalid. Claim cannot be submitted.");
            return false;
        }

        // Simulate claim submission (this would normally involve an API call or database operation)
        System.out.println("Submitting claim...");
        
        System.out.println("Policy Number: " + policyNumber);
        
        System.out.println("Provider: " + providerName);
        
        System.out.println("Claim Amount: " + amount);

        // Simulate successful claim submission
        System.out.println("Claim successfully submitted to " + providerName + ".");
        
        return true;
    }
    
    
}

