package com.example.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Employee {
  private Long id;

  @NotBlank
  private String name;

  @NotNull @Min(0)
  private Double salary;

  @NotBlank
  private String department;

  public Employee() {}

  public Employee(Long id, String name, Double salary, String department) {
    this.id = id; this.name = name; this.salary = salary; this.department = department;
  }

  public Long getId() {
	return id;
  }

  public void setId(Long id) {
	this.id = id;
  }

  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

  public Double getSalary() {
	return salary;
  }

  public void setSalary(Double salary) {
	this.salary = salary;
  }

  public String getDepartment() {
	return department;
  }

  public void setDepartment(String department) {
	this.department = department;
  }


}

