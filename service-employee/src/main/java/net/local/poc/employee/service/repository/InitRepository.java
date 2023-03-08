package net.local.poc.employee.service.repository;

import org.springframework.stereotype.Component;

import net.local.poc.employee.service.domain.Employee;

@Component
public class InitRepository {
    
    private final EmployeeRepository repository;

    public InitRepository(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void initMemoryDatabase() {
        repository.add(
            Employee.builder()
                        .employeeId(1)
                        .fullName("Jhon")
                        .salary(1000)
                        .departmentId(1).build()
        );

        repository.add(
            Employee.builder()
                        .employeeId(2)
                        .fullName("Mike")
                        .salary(500)
                        .departmentId(1).build()
        );

        repository.add(
            Employee.builder()
                        .employeeId(3)
                        .fullName("Clair")
                        .salary(650)
                        .departmentId(2).build()
        );

        repository.add(
            Employee.builder()
                        .employeeId(4)
                        .fullName("Marie")
                        .salary(950)
                        .departmentId(2).build()
        );
    }
}
