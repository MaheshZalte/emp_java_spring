package com.example.service.impl;

import com.example.exception.NotFoundException;
import com.example.model.Employee;
import com.example.service.EmployeeService;
import com.example.store.InMemoryEmployeeStore;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final InMemoryEmployeeStore store;

  public EmployeeServiceImpl(InMemoryEmployeeStore store) {
    this.store = store;
  }

  @Override
  public Employee create(Employee employee) { return store.save(employee); }

  @Override
  public Employee get(Long id) {
    return store.findById(id).orElseThrow(() -> new NotFoundException("Employee not found: " + id));
  }

  @Override
  public List<Employee> getAll() { return store.findAll(); }

  @Override
  public void delete(Long id) {
    get(id); // will throw if not exists
    store.delete(id);
  }

  @Override
  public Employee updateSalary(Long id, double salary) {
    Employee e = get(id);
    e.setSalary(salary);
    return store.save(e);
  }

  @Override
  public Map<String, Double> averageSalaryPerDept() {
    List<Employee> all = store.findAll();
    Map<String, List<Employee>> byDept = all.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    return byDept.entrySet().stream().collect(Collectors.toMap(
        Map.Entry::getKey,
        e -> e.getValue().stream().mapToDouble(Employee::getSalary).average().orElse(0.0)
    ));
  }

  @Override
  public Employee highestPaid() {
    return store.findAll().stream()
        .max(Comparator.comparingDouble(Employee::getSalary))
        .orElseThrow(() -> new NotFoundException("No employees present"));
  }

  @Override
  public List<Employee> earningAboveOverallAverage() {
    List<Employee> all = store.findAll();
    double avg = all.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
    return all.stream().filter(e -> e.getSalary() > avg).collect(Collectors.toList());
  }
}
