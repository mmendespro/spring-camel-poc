package net.local.poc.employee.service.repository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import net.local.poc.employee.service.domain.Employee;

@Repository
public class EmployeeRepository {

    private Map<Integer,Employee> inMemoryDB = new TreeMap<>();

    public void add(Employee employee) {
        inMemoryDB.putIfAbsent(employee.getEmployeeId(), employee);
    }

    public List<Employee> findAll() {
        return inMemoryDB.values().stream().collect(Collectors.toList());
    }

    public Employee findById(Integer employeeId) {
        return inMemoryDB.get(employeeId);
    }

    public List<Employee> findByDepartmentId(Integer departmentId) {
        return inMemoryDB.values().stream().filter(emp -> emp.getDepartmentId().equals(departmentId)).collect(Collectors.toList());
    }

    public void delete(Integer employeeId) {
        inMemoryDB.remove(employeeId);
    }
}
