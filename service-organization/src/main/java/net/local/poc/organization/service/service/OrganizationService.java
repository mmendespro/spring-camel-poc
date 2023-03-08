package net.local.poc.organization.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.local.poc.organization.service.domain.Organization;
import net.local.poc.organization.service.repository.OrganizationRepository;

@Service
public class OrganizationService {

    private final OrganizationRepository repository;

    public OrganizationService(OrganizationRepository repository) {
        this.repository = repository;
    }

    public List<Organization> listAll() {
        return repository.findAll();
    }

    public Organization listById(Integer organizationId) {
        return repository.findById(organizationId);
    }

    public void createOrganization(Organization organization) {
        repository.add(organization);
    }    
}
