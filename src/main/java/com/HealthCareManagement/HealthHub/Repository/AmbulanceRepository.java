package com.HealthCareManagement.HealthHub.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HealthCareManagement.HealthHub.Entity.Ambulance;

@Repository
public interface AmbulanceRepository extends JpaRepository<Ambulance, Long> {
	
    List<Ambulance> findByStatus(String status);
    
    Ambulance findByVehicleNumber(String vehicleNumber);
    
}

