package com.capgemini.employeepayrollapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ✅ Do not use @NotEmpty or any validation here

    @NotBlank(message = "Name cannot be empty")  // ✅ Correct validation for a String
    private String name;

    @NotNull(message = "Salary cannot be null")  // ✅ Correct validation for a number
    private Double salary;


    public Employee(@Pattern(regexp = "^[A-Z][a-zA-Z ]{2,}$", message = "Name must start with a capital letter and have at least 3 characters") String name, @Positive(message = "Salary must be a positive number") double salary) {
    }
}
