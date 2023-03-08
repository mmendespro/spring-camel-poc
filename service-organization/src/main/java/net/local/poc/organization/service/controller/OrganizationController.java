package net.local.poc.organization.service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.organization.service.domain.Organization;
import net.local.poc.organization.service.service.OrganizationService;


@RestController
@RequestMapping(path = "/organizations")
public class OrganizationController {
    
    private final OrganizationService service;

    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Organization organization) {
        service.createOrganization(organization);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Organization>> listAllOrganizations() {
        return new ResponseEntity<List<Organization>>(service.listAll(), HttpStatus.OK);
    } 

    @GetMapping(path = "{organizationId}")
    public ResponseEntity<Organization> listById(@PathVariable(name = "organizationId") Integer organizationId) {
        return new ResponseEntity<Organization>(service.listById(organizationId), HttpStatus.OK);
    } 
}
