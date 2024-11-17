package com.HealthCareManagement.HealthHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HealthCareManagement.HealthHub.Entity.InsuranceProvider;

@Repository
public interface InsuranceProviderRepository extends JpaRepository<InsuranceProvider, Long> {
	
    InsuranceProvider findByName(String name);
}

