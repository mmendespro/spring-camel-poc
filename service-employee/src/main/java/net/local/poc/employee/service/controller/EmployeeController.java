package net.local.poc.employee.service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.employee.service.domain.Employee;
import net.local.poc.employee.service.service.EmployeeService;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Employee employee) {
        service.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Employee>> listAllEmployees() {
        return new ResponseEntity<List<Employee>>(service.listAll(), HttpStatus.OK);
    } 

    @GetMapping(path = "{employeeId}")
    public ResponseEntity<Employee> listById(@PathVariable(name = "employeeId") Integer employeeId) {
        return new ResponseEntity<Employee>(service.listById(employeeId), HttpStatus.OK);
    } 

    @GetMapping(path = "/bydepartment/{departmentId}")
    public ResponseEntity<List<Employee>> listByDepartment(@PathVariable(name = "departmentId") Integer departmentId) {
        return new ResponseEntity<List<Employee>>(service.listByDepartmentId(departmentId), HttpStatus.OK);
    } 
}
