package com.example.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class SalaryUpdateRequest {
  @NotNull @Min(0)
  private Double salary;
  public Double getSalary() { return salary; }
  public void setSalary(Double salary) { this.salary = salary; }
}
