package com.hyper.employee.dao;

import com.hyper.employee.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee, Long> {

    @Query(value = "SELECT e FROM Employee e JOIN FETCH e.team t")
    List<Employee> findAllWithTeams();

}
