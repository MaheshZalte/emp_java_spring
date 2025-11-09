package com.example.controller;

import com.example.model.Employee;
import com.example.model.dto.AverageSalaryResponse;
import com.example.model.dto.SalaryUpdateRequest;
import com.example.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
  private final EmployeeService service;
  public EmployeeController(EmployeeService service) { this.service = service; }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Employee create(@Valid @RequestBody Employee employee) {
    return service.create(employee);
  }

  @GetMapping("/{id}")
  public Employee get(@PathVariable Long id) { return service.get(id); }

  @GetMapping("/all")
  public List<Employee> all() { return service.getAll(); }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) { service.delete(id); }

  @PutMapping("/update-salary")
  public Employee updateSalary(@RequestParam Long id, @Valid @RequestBody SalaryUpdateRequest req) {
    return service.updateSalary(id, req.getSalary());
  }

  @GetMapping("/average-salary")
  public AverageSalaryResponse averageSalaryPerDept() {
    return new AverageSalaryResponse(service.averageSalaryPerDept());
  }

  @GetMapping("/highest-salary")
  public Employee highestSalary() { return service.highestPaid(); }

  @GetMapping("/above-average")
  public List<Employee> aboveAverage() { return service.earningAboveOverallAverage(); }
}
