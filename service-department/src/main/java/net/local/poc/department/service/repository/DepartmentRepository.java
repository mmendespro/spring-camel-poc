package net.local.poc.department.service.repository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import net.local.poc.department.service.domain.Department;

@Repository
public class DepartmentRepository {

    private Map<Integer,Department> inMemoryDB = new TreeMap<>();

    public void add(Department department) {
        inMemoryDB.putIfAbsent(department.getDepartmentId(), department);
    }

    public List<Department> findAll() {
        return inMemoryDB.values().stream().collect(Collectors.toList());
    }

    public Department findById(Integer departmentId) {
        return inMemoryDB.get(departmentId);
    }

    public List<Department> findByOrganizationId(Integer organizationId) {
        return inMemoryDB.values().stream().filter(dep -> dep.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
    }

    public void delete(Integer departmentId) {
        inMemoryDB.remove(departmentId);
    }
}
