package com.hyper.employee.service;

import com.hyper.employee.entity.Employee;
import com.hyper.employee.entity.Team;
import com.hyper.employee.service.dto.EmployeeDto;
import com.hyper.employee.service.dto.TeamDto;

import java.util.ArrayList;
import java.util.List;

public class Transform {

    public static EmployeeDto transformEmployee(Employee employee, int transformLevel) {
        EmployeeDto dto = new EmployeeDto();
        dto.setId( employee.getId() );
        dto.setName( employee.getName() );
        if (transformLevel > 0) {
            transformLevel--;
            if (employee.getTeam() != null) {
                dto.setTeam( transformTeam( employee.getTeam(), transformLevel ) );
            }
        }
        return dto;
    }

    public static List<EmployeeDto> transformEmployees(List<Employee> employees, int transformLevel) {
        List<EmployeeDto> dtos = new ArrayList<>();
        for (Employee employee : employees) {
            dtos.add( transformEmployee( employee, transformLevel ) );
        }
        return dtos;
    }

    public static TeamDto transformTeam(Team team, int transformLevel) {
        TeamDto dto = new TeamDto();
        dto.setId( team.getId() );
        dto.setName( team.getName() );
        if (transformLevel > 0) {
            transformLevel--;
            if (team.getTeamLead() != null) {
                dto.setTeamLead( transformEmployee( team.getTeamLead(), transformLevel ) );
            }
        }
        return dto;
    }

    public static List<TeamDto> transformTeams(List<Team> teams, int transformLevel) {
        List<TeamDto> dtos = new ArrayList<>();
        for (Team team : teams) {
            dtos.add( transformTeam( team, transformLevel ) );
        }
        return dtos;
    }

}
