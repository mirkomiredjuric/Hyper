package com.hyper.employee.controller;

import com.hyper.employee.entity.Employee;
import com.hyper.employee.service.EmployeeService;
import com.hyper.employee.service.dto.EmployeeDto;
import com.hyper.employee.service.dto.EmployeeResponse;
import com.hyper.employee.service.dto.SaveEmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private static final Logger LOGGER = Logger.getLogger( EmployeeController.class.getName() );

    private final EmployeeService employeeService;

    @GetMapping(value = { "", "/", "/*", "/all" })
    public List<EmployeeDto> getAll() {
        LOGGER.log( Level.INFO, "Getting all employees." );
        return employeeService.getAll();
    }

    @GetMapping(value = { "/allEmp" })
    public List<EmployeeResponse> getAllEmployees() {
        LOGGER.log( Level.INFO, "Getting all employees." );
        return employeeService.findAllEmployees();
    }

    @GetMapping(value = { "/{id}", "/get/{id}" })
    public EmployeeDto getById(@PathVariable("id") Long id) {
        LOGGER.log( Level.INFO, "Getting employee by id: " + id );
        return employeeService.getById( id );
    }

    @DeleteMapping(value = { "/{id}", "/delete/{id}" })
    public void deleteById(@PathVariable("id") Long id) {
        LOGGER.log( Level.INFO, "Deleting employee by id: " + id );
        employeeService.deleteById( id );
    }

    @PostMapping(value = { "", "/", "/save" })
    public Long saveEmployee(@Valid @RequestBody SaveEmployeeDto dto) {
        LOGGER.log( Level.INFO, "Saving employee: " + dto );
        return employeeService.saveEmployee( dto );
    }

}
