package com.example.service;

import com.example.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
  Employee create(Employee employee);
  Employee get(Long id);
  List<Employee> getAll();
  void delete(Long id);
  Employee updateSalary(Long id, double salary);
  Map<String, Double> averageSalaryPerDept();
  Employee highestPaid();
  List<Employee> earningAboveOverallAverage();
}
