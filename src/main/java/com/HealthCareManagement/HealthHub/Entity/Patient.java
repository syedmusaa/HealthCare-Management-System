package com.HealthCareManagement.HealthHub.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank(message = "First Name is required")
    @Size(max = 100, message = "Name must be less than 100 characters")
    @Column(nullable = false)
    private String firstName;

	@NotBlank(message = "Last Name is required")
    @Size(max = 100, message = "Name must be less than 100 characters")
    @Column(nullable = false)
    private String lastName;
	
	@NotBlank(message = "Gender is required")
    @Size(max = 100, message = "Gender must be Male, Female and Others ")
    @Column(nullable = false)
    private String gender;

	@NotBlank(message = "Email is required")
    @Size(max = 100, message = "Email Should be Valid")
    @Column(nullable = false, unique = true)
    private String email;

	@NotBlank(message = "Date of Birth is required")
    @Size(max = 100, message = "Date of Birth:- dd/mm/yyyy")
    @Column(nullable = false)
    private LocalDate dateOfBirth;

	@NotBlank(message = "Phone Number is required")
    @Size(max = 100, message = "Phone Number Should be Valid")
    @Column(nullable = false)
    private long phoneNumber;

	@Lob // @Lob is used for lists
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @Lob // @Lob is used for lists
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<MedicalRecord> medicalRecords;


    // Getters and setters
}
