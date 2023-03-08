package net.local.poc.department.service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private Integer departmentId;
    private String departmentName;
    private Integer organizationId;
}
