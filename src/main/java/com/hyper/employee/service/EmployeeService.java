package com.hyper.employee.service;

import com.hyper.employee.dao.EmployeeRepository;
import com.hyper.employee.dao.TeamRepository;
import com.hyper.employee.entity.Employee;
import com.hyper.employee.service.dto.EmployeeDto;
import com.hyper.employee.service.dto.EmployeeResponse;
import com.hyper.employee.service.dto.SaveEmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TeamRepository teamRepository;

    public EmployeeService(EmployeeRepository employeeRepository, TeamRepository teamRepository) {
        this.employeeRepository = employeeRepository;
        this.teamRepository = teamRepository;
    }

    public List<EmployeeResponse> findAllEmployees(){
        List<EmployeeResponse> employees = employeeRepository.findAllEmployees();
        return employees;
    }

    public List<EmployeeDto> getAll() {
        List<Employee> employees = employeeRepository.findAllWithTeams();
        return Transform.transformEmployees( employees, 1 ); //3
    }

    public EmployeeDto getById(Long id) {
        Employee employee = employeeRepository.findOrThrowException( id );
        return Transform.transformEmployee( employee, 1 );
    }

    public void deleteById(Long id) {
        employeeRepository.findOrThrowException( id );
        employeeRepository.deleteById( id );
    }

    public Long saveEmployee(SaveEmployeeDto dto) {
        Employee entity;
        if (dto.getId() == null) {
            entity = new Employee();
        } else {
            entity = employeeRepository.findOrThrowException( dto.getId() );
        }

        entity.setName( dto.getName() );
        if (dto.getTeamId() != null) {
            entity.setTeam( teamRepository.findOrThrowException( dto.getTeamId() ) );
        }else{
            entity.setTeam( null );
        }

        return employeeRepository.save( entity ).getId();
    }

}
