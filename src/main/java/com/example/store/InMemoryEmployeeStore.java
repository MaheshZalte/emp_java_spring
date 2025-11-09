package com.example.store;

import com.example.model.Employee;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class InMemoryEmployeeStore {
  private final Map<Long, Employee> map = new ConcurrentHashMap<>();
  private final AtomicLong seq = new AtomicLong(0);

  public Employee save(Employee e) {
    if (e.getId() == null) e.setId(seq.incrementAndGet());
    map.put(e.getId(), e);
    return e;
  }

  public Optional<Employee> findById(Long id) { return Optional.ofNullable(map.get(id)); }
  public List<Employee> findAll() { return new ArrayList<>(map.values()); }
  public void delete(Long id) { map.remove(id); }
}
