package com.HealthCareManagement.HealthHub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareManagement.HealthHub.Entity.Appointment;
import com.HealthCareManagement.HealthHub.Repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
    private AppointmentRepository appointmentRepository;
	
	

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
    
    
    

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
        		.orElseThrow(() -> new RuntimeException("Appointment not found"));
    }
    
    
    
    

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    
    

    public Appointment updateAppointment(Long id, Appointment appointment) {
        Appointment existingAppointment = getAppointmentById(id);
        
        existingAppointment.setPatient(appointment.getPatient());
        
        existingAppointment.setAppointmentDateTime(appointment.getAppointmentDateTime());
        
        existingAppointment.setDoctorName(appointment.getDoctorName());
        
        existingAppointment.setAppointmentType(appointment.getAppointmentType());
      
        existingAppointment.setNotes(appointment.getNotes());
        
        existingAppointment.setStatus(appointment.getStatus());
        
        return appointmentRepository.save(existingAppointment);
    }

    
    
    
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
    
    
    
    
}
