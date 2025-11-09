package com.example.util;

import com.example.model.Employee;
import com.example.store.InMemoryEmployeeStore;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleDataLoader implements CommandLineRunner {
  private final InMemoryEmployeeStore store;
  public SampleDataLoader(InMemoryEmployeeStore store) { this.store = store; }

  @Override
  public void run(String... args) {
    store.save(new Employee(null, "Asha", 80000.0, "Engineering"));
    store.save(new Employee(null, "Ravi", 65000.0, "Engineering"));
    store.save(new Employee(null, "Meera", 90000.0, "Finance"));
    store.save(new Employee(null, "Kunal", 70000.0, "HR"));
  }
}
