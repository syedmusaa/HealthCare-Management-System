package com.HealthCareManagement.HealthHub.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareManagement.HealthHub.Entity.Ambulance;
import com.HealthCareManagement.HealthHub.Repository.AmbulanceRepository;

@Service
public class AmbulanceService {

	@Autowired
    private  AmbulanceRepository ambulanceRepository;

//    @Autowired
//    public AmbulanceService(AmbulanceRepository ambulanceRepository) {
//        this.ambulanceRepository = ambulanceRepository;
//    }

    public List<Ambulance> getAllAmbulances() {
        return ambulanceRepository.findAll();
    }
    
    
    

    public Optional<Ambulance> getAmbulanceById(Long id) {
        return ambulanceRepository.findById(id);
    }
    
    
    

    public List<Ambulance> getAmbulancesByStatus(String status) {
        return ambulanceRepository.findByStatus(status);
    }
    
    
    
    

    public Ambulance getAmbulanceByVehicleNumber(String vehicleNumber) {
        return ambulanceRepository.findByVehicleNumber(vehicleNumber);
    }
    
    
    
    

    public Ambulance createAmbulance(Ambulance ambulance) {
        return ambulanceRepository.save(ambulance);
    }
    
    
    
    

    public Ambulance updateAmbulance(Long id, Ambulance ambulanceDetails) {
    	
        Ambulance ambulance = ambulanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ambulance not found with id: " + id));

        ambulance.setDriverName(ambulanceDetails.getDriverName());
        
        ambulance.setVehicleNumber(ambulanceDetails.getVehicleNumber());
        
        ambulance.setCurrentLocation(ambulanceDetails.getCurrentLocation());
        
        ambulance.setStatus(ambulanceDetails.getStatus());

        return ambulanceRepository.save(ambulance);
    }
    
    
    
    


    public Ambulance updateAmbulanceLocation(Long id, String newLocation, String newDriver) {
    	
        Ambulance ambulance = ambulanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ambulance not found with id: " + id));

        ambulance.setCurrentLocation(newLocation);
       
        ambulance.setDriverName(newDriver);
        
        return ambulanceRepository.save(ambulance);
    }
    
    
    
public Ambulance updateAmbulanceDriver(Long id, String newDriver) {
    	
        Ambulance ambulance = ambulanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ambulance not found with id: " + id));

        ambulance.setCurrentLocation(newDriver);
       
        
        return ambulanceRepository.save(ambulance);
    }
    
    
    
    
    
    
    
    

    public Ambulance updateAmbulanceStatus(Long id, String newStatus) {
    	
        Ambulance ambulance = ambulanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ambulance not found with id: " + id));

        ambulance.setStatus(newStatus);
        
        return ambulanceRepository.save(ambulance);
    }
    
    
    
    
    
    public void deleteAmbulance(Long id) {
    	
        ambulanceRepository.deleteById(id);
    }
    
    
    
}
