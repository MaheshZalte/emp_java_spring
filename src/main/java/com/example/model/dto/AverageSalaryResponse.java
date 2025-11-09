package com.example.model.dto;

import java.util.Map;

public class AverageSalaryResponse {
  private Map<String, Double> averageByDepartment;
  public AverageSalaryResponse(Map<String, Double> map) { this.averageByDepartment = map; }
  public Map<String, Double> getAverageByDepartment() { return averageByDepartment; }
}
