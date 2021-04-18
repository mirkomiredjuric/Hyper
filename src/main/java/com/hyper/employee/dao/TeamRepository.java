package com.hyper.employee.dao;

import com.hyper.employee.entity.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends BaseRepository<Team, Long> {

    @Query(value = "SELECT t FROM Team t JOIN FETCH t.teamLead e")
    List<Team> findAllWithTeamLeads();

}
