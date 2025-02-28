package com.capgemini.employeepayrollapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data  // Generates Getters, Setters, toString(), equals(), and hashCode()
@NoArgsConstructor
@AllArgsConstructor
public @ToString class EmployeeDTO {
    @NotNull(message = "ID cannot be empty")
    @Min(value = 1, message = "ID must be greater than or equal to 1")
    public Long id;  // Use Long to match with the Entity
    @NotNull(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z ]{2,}$", message = "Name must start with a capital letter and have at least 3 characters")
    public String name;
    public double salary;
    public String gender;
    public String startDate;
    public String note;
    public String profilePic;
    public String department;
}