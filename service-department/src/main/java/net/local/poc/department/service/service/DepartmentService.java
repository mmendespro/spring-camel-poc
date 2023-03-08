package net.local.poc.department.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.local.poc.department.service.domain.Department;
import net.local.poc.department.service.repository.DepartmentRepository;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public List<Department> listAll() {
        return repository.findAll();
    }

    public Department listById(Integer employeeId) {
        return repository.findById(employeeId);
    }

    public List<Department> listByOrganizationId(Integer organizationId) {
        return repository.findByOrganizationId(organizationId);
    }

    public void createDepartment(Department department) {
        repository.add(department);
    }    
}
