package com.hyper.employee.service;

import com.hyper.employee.dao.EmployeeRepository;
import com.hyper.employee.dao.TeamRepository;
import com.hyper.employee.entity.Team;
import com.hyper.employee.service.dto.SaveTeamDto;
import com.hyper.employee.service.dto.TeamDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final EmployeeRepository employeeRepository;

    public TeamService(TeamRepository teamRepository, EmployeeRepository employeeRepository) {
        this.teamRepository = teamRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<TeamDto> getAll() {
        List<Team> teams = teamRepository.findAllWithTeamLeads();
        return Transform.transformTeams( teams, 1 );
    }

    public TeamDto getById(Long id) {
        Team team = teamRepository.findOrThrowException( id );
        return Transform.transformTeam( team, 1 );
    }

    public void deleteById(Long id) {
        teamRepository.findOrThrowException( id );
        teamRepository.deleteById( id );
    }

    public Long saveTeam(SaveTeamDto dto) {
        Team entity;
        if (dto.getId() == null) {
            entity = new Team();
        } else {
            entity = teamRepository.findOrThrowException( dto.getId() );
        }

        entity.setName( dto.getName() );
        if (dto.getTeamLeadId() != null) {
            entity.setTeamLead( employeeRepository.findOrThrowException( dto.getTeamLeadId() ) );
        }else{
            entity.setTeamLead( null );
        }

        return teamRepository.save( entity ).getId();
    }

}
