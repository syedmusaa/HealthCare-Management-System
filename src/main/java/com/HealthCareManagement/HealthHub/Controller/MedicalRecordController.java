package com.HealthCareManagement.HealthHub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.HealthCareManagement.HealthHub.Entity.MedicalRecord;
import com.HealthCareManagement.HealthHub.Service.MedicalRecordService;

@RestController
@RequestMapping("/medical-records")
public class MedicalRecordController {
	
	@Autowired
    private MedicalRecordService medicalRecordService;

    @PostMapping("/new")
    public ResponseEntity<MedicalRecord> createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return ResponseEntity.ok(medicalRecordService.saveMedicalRecord(medicalRecord));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> getMedicalRecord(@PathVariable Long id) {
        return ResponseEntity.ok(medicalRecordService.getMedicalRecordById(id));
    }

    @GetMapping
    public ResponseEntity<List<MedicalRecord>> getAllMedicalRecords() {
        return ResponseEntity.ok(medicalRecordService.getAllMedicalRecords());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalRecord> updateMedicalRecord(@PathVariable Long id, @RequestBody MedicalRecord medicalRecord) {
        return ResponseEntity.ok(medicalRecordService.updateMedicalRecord(id, medicalRecord));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable Long id) {
        medicalRecordService.deleteMedicalRecord(id);
        return ResponseEntity.ok().build();
    }
}

