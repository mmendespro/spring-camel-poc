package net.local.poc.organization.service.repository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import net.local.poc.organization.service.domain.Organization;

@Repository
public class OrganizationRepository {

    private Map<Integer,Organization> inMemoryDB = new TreeMap<>();

    public void add(Organization organization) {
        inMemoryDB.putIfAbsent(organization.getOrganizationId(), organization);
    }

    public List<Organization> findAll() {
        return inMemoryDB.values().stream().collect(Collectors.toList());
    }

    public Organization findById(Integer organizationId) {
        return inMemoryDB.get(organizationId);
    }

    public void delete(Integer organizationId) {
        inMemoryDB.remove(organizationId);
    }
}
