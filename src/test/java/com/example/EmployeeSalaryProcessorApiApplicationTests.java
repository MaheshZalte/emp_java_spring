package com.example;

import com.example.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeSalaryProcessorApiApplicationTests {

  @Autowired MockMvc mockMvc;
  @Autowired ObjectMapper om;

  @Test
  void createAndGet() throws Exception {
    Employee e = new Employee(null, "Test", 50000.0, "QA");
    mockMvc.perform(post("/employee")
        .contentType(MediaType.APPLICATION_JSON)
        .content(om.writeValueAsString(e)))
      .andExpect(status().isCreated())
      .andExpect(jsonPath("$.id").exists());

    mockMvc.perform(get("/employee/all"))
      .andExpect(status().isOk());
  }
}

