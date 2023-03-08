package net.local.poc.organization.service.repository;

import org.springframework.stereotype.Component;

import net.local.poc.organization.service.domain.Organization;


@Component
public class InitRepository {
    
    private final OrganizationRepository repository;

    public InitRepository(OrganizationRepository repository) {
        this.repository = repository;
    }

    public void initMemoryDatabase() {
        repository.add(
            Organization.builder()
                            .organizationId(1)
                            .organizationName("Avanade").build()
        );

        repository.add(
            Organization.builder()
                            .organizationId(2)
                            .organizationName("Accenture").build()
        );
    }
}
