package net.local.poc.department.service.repository;

import org.springframework.stereotype.Component;

import net.local.poc.department.service.domain.Department;


@Component
public class InitRepository {
    
    private final DepartmentRepository repository;

    public InitRepository(DepartmentRepository repository) {
        this.repository = repository;
    }

    public void initMemoryDatabase() {
        repository.add(
            Department.builder()
                        .departmentId(1)
                        .departmentName("Marketing")
                        .organizationId(1).build()
        );

        repository.add(
            Department.builder()
                        .departmentId(2)
                        .departmentName("Human Resources")
                        .organizationId(1).build()
        );

        repository.add(
            Department.builder()
                        .departmentId(3)
                        .departmentName("IT")
                        .organizationId(2).build()
        );

        repository.add(
            Department.builder()
                        .departmentId(4)
                        .departmentName("Insurance")
                        .organizationId(2).build()
        );
    }
}
