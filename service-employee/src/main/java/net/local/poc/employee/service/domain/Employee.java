package net.local.poc.employee.service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Integer employeeId;
    private String fullName;
    private float salary;
    private Integer departmentId;
}
