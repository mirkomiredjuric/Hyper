package com.hyper.employee.service.dto;

import lombok.Data;

@Data
public class EmployeeDto {

    private Long    id;
    private String  name;
    private TeamDto team;
}
