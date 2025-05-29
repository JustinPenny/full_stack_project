package tech.getarrays.employeemanager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

    // These functions were created by the IDE by attemping to call employeeRepo.findEmployeeById(id); in the EmployeeService.java and then allowing
    // the IDE to quick fix the issue. Spring can tell based on naming convention what should be created to fix the issue
    // Look up JPA Query Method creation for more info
    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);

}
