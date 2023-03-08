package net.local.poc.department.service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.department.service.domain.Department;
import net.local.poc.department.service.service.DepartmentService;


@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Department department) {
        service.createDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Department>> listAllDepartments() {
        return new ResponseEntity<List<Department>>(service.listAll(), HttpStatus.OK);
    } 

    @GetMapping(path = "{departmentId}")
    public ResponseEntity<Department> listById(@PathVariable(name = "departmentId") Integer departmentId) {
        return new ResponseEntity<Department>(service.listById(departmentId), HttpStatus.OK);
    } 

    @GetMapping(path = "/byorganization/{organizationId}")
    public ResponseEntity<List<Department>> listByDepartment(@PathVariable(name = "organizationId") Integer organizationId) {
        return new ResponseEntity<List<Department>>(service.listByOrganizationId(organizationId), HttpStatus.OK);
    } 
}
