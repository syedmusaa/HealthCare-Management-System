package com.HealthCareManagement.HealthHub.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.HealthCareManagement.HealthHub.Entity.Appointment;
import com.HealthCareManagement.HealthHub.Service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
    private AppointmentService appointmentService;

    @PostMapping("/new")
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
    	Appointment saveAppointment = appointmentService.saveAppointment(appointment);
        return ResponseEntity.ok(saveAppointment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
    	List<Appointment> appointment = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.updateAppointment(id, appointment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok().build();
    }
}

