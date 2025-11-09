🧾 README.md
# 💼 Employee Salary Processor API

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Maven](https://img.shields.io/badge/Build-Maven-orange)
![REST API](https://img.shields.io/badge/API-REST-lightgrey)

A **Spring Boot REST API** that manages employee data and performs various salary-related operations such as calculating average salary per department, finding the highest-paid employee, and listing employees earning above the average.

This project was developed as part of the **Java Spring Boot Microservices Developer Internship Assignment** for **Glaciersoft Technologies**.

---

## 🚀 Project Overview

This RESTful API demonstrates key backend development concepts using **Spring Boot**, including:

- REST API design and best practices  
- Service layer architecture  
- Data management using in-memory storage  
- Validation and exception handling  
- Computation and business logic implementation  

---

## 🧩 Tech Stack

| Category | Technology |
|-----------|-------------|
| Language | **Java 21** |
| Framework | **Spring Boot 3.x** |
| Build Tool | **Maven** |
| Dependencies | `spring-boot-starter-web`, `spring-boot-starter-validation`, `spring-boot-starter-test` |

---

## 📁 Project Structure

```bash
emp_java_spring/
├── 📄 pom.xml                                # Maven build configuration file
├── 🧾 README.md                              # Project documentation
└── 📂 src/
    ├── 📁 main/
    │   ├── 📁 java/
    │   │   └── 📦 com/example/emp/           # Root package for the project
    │   │       ├── 🚀 EmpApplication.java                # Main Spring Boot application entry point
    │   │       │
    │   │       ├── 📂 controller/                        # REST API controllers
    │   │       │   └── EmployeeController.java
    │   │       │
    │   │       ├── 📂 service/                           # Service layer interfaces
    │   │       │   ├── EmployeeService.java
    │   │       │   └── 📂 impl/                          # Service implementations
    │   │       │       └── EmployeeServiceImpl.java
    │   │       │
    │   │       ├── 📂 model/                             # Data models (POJOs)
    │   │       │   ├── Employee.java
    │   │       │   └── 📂 dto/                           # DTOs for requests/responses
    │   │       │       ├── SalaryUpdateRequest.java
    │   │       │       └── AverageSalaryResponse.java
    │   │       │
    │   │       ├── 📂 store/                             # In-memory data storage
    │   │       │   └── InMemoryEmployeeStore.java
    │   │       │
    │   │       ├── 📂 exception/                         # Custom exceptions & global handlers
    │   │       │   ├── NotFoundException.java
    │   │       │   └── GlobalExceptionHandler.java
    │   │       │
    │   │       └── 📂 util/                              # Utility classes
    │   │           └── SampleDataLoader.java
    │   │
    │   └── 📁 resources/
    │       ├── ⚙️ application.properties                 # Spring Boot configuration file
    │       └── 🧩 static/ (optional)                     # Static resources (CSS/JS/images)
    │
    └── 📁 test/
        └── 📦 com/example/emp/
            └── EmployeeControllerTest.java               # Unit tests using MockMvc


---

## ⚙️ Setup & Run Instructions

### 1️⃣ Prerequisites
Ensure you have installed:
- **Java 17+**
- **Maven**

Verify:
```bash
java -version
mvn -v

2️⃣ Clone the Repository
git clone https://github.com/<your-username>/emp_java_spring.git
cd emp_java_spring

3️⃣ Run the Application
Option 1 — Using Maven
mvn spring-boot:run

Option 2 — Using JAR
mvn clean package
java -jar target/emp_java_spring-0.0.1-SNAPSHOT.jar


Then open your browser:
👉 http://localhost:8080/employee/all

🌐 API Endpoints
Method	Endpoint	Description
POST	/employee	Create a new employee
GET	/employee/{id}	Get employee by ID
GET	/employee/all	Get all employees
PUT	/employee/update-salary?id={id}	Update employee salary
DELETE	/employee/{id}	Delete employee by ID
GET	/employee/average-salary	Calculate average salary per department
GET	/employee/highest-salary	Find highest paid employee
GET	/employee/above-average	List employees earning above the average
🧪 Example Requests
➕ Create Employee

POST /employee

{
  "name": "Mahesh",
  "salary": 80000,
  "department": "Engineering"
}

🔄 Update Salary

PUT /employee/update-salary?id=1

{
  "salary": 90000
}

📊 Average Salary Per Department

GET /employee/average-salary

{
  "averageByDepartment": {
    "Engineering": 85000,
    "Finance": 90000,
    "HR": 70000
  }
}

🛡️ Features Implemented

✅ Clean REST API architecture
✅ In-memory data storage (no database required)
✅ Input validation with jakarta.validation
✅ Global exception handling
✅ Unit testing with MockMvc
✅ Clear, modular, and maintainable code

🧠 Future Enhancements

Integrate with a real database (MySQL/PostgreSQL)

Add Swagger/OpenAPI documentation

Implement pagination and sorting

Dockerize and deploy on cloud (AWS/Render)

Add JWT-based authentication

🧰 Postman Collection

You can test all endpoints easily using Postman.
👉 Import this collection:
Employee_Salary_Processor_API.postman_collection.json

Or run via cURL:

curl -X GET http://localhost:8080/employee/all

👨‍💻 Author

Mahesh Zalte
🎓 B.Tech in Computer Science and Engineering (AI Specialization)
📍 Vadodara, Gujarat, India

🔗 GitHub
 | LinkedIn
