package com.akshay.CRUD.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Email of the employees can not be blank")
    @Size(min = 3, max = 10, message = "Numbers of characters in the name should be in the range: [3,10]")
    private String name;

    @NotBlank(message = "Email of the employees can not be blank")
    @Email(message = "Email should be a valid email")
    private String email;

    @NotNull(message = "Age of the employees can not be blank")
    @Max(value = 80, message = "Age of the employee can not be greater than 80")
    @Min(value = 18, message = "Age of the employee can not be less than 18")
    private Integer age;

    @PastOrPresent(message = "Date of Joining in employee can not be in future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private boolean isActive;

    @NotBlank(message = "Role of the employee can not be blank")
    private String role;

    @NotNull(message = "Salary of the employees should not be null")
    @Positive(message = "Salary of the employees should be positive")
    @Digits(integer = 6, fraction = 2, message = "The salary can be in the form XXXXX.YY")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private double salary;

}
