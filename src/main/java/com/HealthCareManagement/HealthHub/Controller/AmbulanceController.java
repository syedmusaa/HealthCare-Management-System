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

import com.HealthCareManagement.HealthHub.Entity.Ambulance;
import com.HealthCareManagement.HealthHub.Service.AmbulanceService;

@RestController
@RequestMapping("/ambulances")
public class AmbulanceController {

	@Autowired
    private  AmbulanceService ambulanceService;

//    @Autowired
//    public AmbulanceController(AmbulanceService ambulanceService) {
//        this.ambulanceService = ambulanceService;
//    }

    @GetMapping
    public List<Ambulance> getAllAmbulances() {
        return ambulanceService.getAllAmbulances();
    }
    
    
    

    @GetMapping("/{id}")
    public ResponseEntity<Ambulance> getAmbulanceById(@PathVariable Long id) {
        
    	return ambulanceService.getAmbulanceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    
    
    
    

    @GetMapping("/status/{status}")
    public List<Ambulance> getAmbulancesByStatus(@PathVariable String status) {
        
    	return ambulanceService.getAmbulancesByStatus(status);
    }
    
    
    
    

    @GetMapping("/vehicle/{vehicleNumber}")
    public ResponseEntity<Ambulance> getAmbulanceByVehicleNumber(@PathVariable String vehicleNumber) {
        
    	Ambulance ambulance = ambulanceService.getAmbulanceByVehicleNumber(vehicleNumber);
        
        return ambulance != null ? ResponseEntity.ok(ambulance) : ResponseEntity.notFound().build();
    }
    
    
    
    
    

    @PostMapping
    public Ambulance createAmbulance(@RequestBody Ambulance ambulance) {
        
    	return ambulanceService.createAmbulance(ambulance);
    }
    
    
    
    

    @PutMapping("/{id}")
    public ResponseEntity<Ambulance> updateAmbulance(@PathVariable Long id, @RequestBody Ambulance ambulanceDetails) {
        
    	Ambulance updatedAmbulance = ambulanceService.updateAmbulance(id, ambulanceDetails);
        
    	return ResponseEntity.ok(updatedAmbulance);
    }
    
    
    

    @PutMapping("/{id}/location")
    public ResponseEntity<Ambulance> updateAmbulanceLocation(@PathVariable Long id, @RequestParam String newLocation, @RequestParam String newDriver) {
        
    	Ambulance updatedAmbulance = ambulanceService.updateAmbulanceLocation(id, newLocation, newDriver);
        
    	return ResponseEntity.ok(updatedAmbulance);
    }
    
    
    
    @PutMapping("/{id}/driver")
    public ResponseEntity<Ambulance> updateAmbulanceDriver(@PathVariable Long id, @RequestParam String newDriver) {
        
    	Ambulance updatedAmbulance = ambulanceService.updateAmbulanceDriver(id, newDriver);
        
    	return ResponseEntity.ok(updatedAmbulance);
    }
    
    
    
    

    @PutMapping("/{id}/status")
    public ResponseEntity<Ambulance> updateAmbulanceStatus(@PathVariable Long id, @RequestParam String newStatus) {
        
    	Ambulance updatedAmbulance = ambulanceService.updateAmbulanceStatus(id, newStatus);
        
    	return ResponseEntity.ok(updatedAmbulance);
    }
    
    
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmbulance(@PathVariable Long id) {
    	
        ambulanceService.deleteAmbulance(id);
        
        return ResponseEntity.ok().build();
    }
    
    
    
}

