package net.local.poc.employee.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.local.poc.employee.service.domain.Employee;
import net.local.poc.employee.service.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> listAll() {
        return repository.findAll();
    }

    public Employee listById(Integer employeeId) {
        return repository.findById(employeeId);
    }

    public List<Employee> listByDepartmentId(Integer departmentId) {
        return repository.findByDepartmentId(departmentId);
    }

    public void createEmployee(Employee employee) {
        repository.add(employee);
    }    
}
