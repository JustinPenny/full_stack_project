package tech.getarrays.employeemanager.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.getarrays.employeemanager.model.Employee;

import java.util.List;

// This mirrors the EmployeeService file.
// The HTTP requests will land here and from here call the respective methods from EmployeeService

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    // Default Constructor
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    

    // Find all employees
    @GetMapping("/all")
    // Using an API client like postman you can send a simple GET request to hit this endpoint:
    // http://localhost:8080/employee/all
    public ResponseEntity<List<Employee>> getAllEmployee (){
        List<Employee> employee = employeeService.findAllEmployees();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    // Find one employee
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getAllEmployee (@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
