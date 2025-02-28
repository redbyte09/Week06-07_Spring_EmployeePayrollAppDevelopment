package com.capgemini.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

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

    @Pattern(regexp = "male|female", message = "Gender need to be male or female")
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "startDate should not ne empty")
    @PastOrPresent(message = "startDate should be past or todays date")
    public LocalDate startDate;

    @NotBlank(message = "note cannot be Empty")
    public String note;

    @NotBlank(message = "profilePic cannot be Empty")
    public String profilePic;

    @NotNull(message = "department cannot be Empty")
    public String department;
}