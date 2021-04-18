package com.hyper.employee.controller;

import com.hyper.employee.service.TeamService;
import com.hyper.employee.service.dto.SaveTeamDto;
import com.hyper.employee.service.dto.TeamDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/team")
@RequiredArgsConstructor
public class TeamController {

    private static final Logger LOGGER = Logger.getLogger( TeamController.class.getName() );

    private final TeamService teamService;

    @GetMapping(value = { "", "/", "/*", "/all" })
    public List<TeamDto> getAll() {
        LOGGER.log( Level.INFO, "Getting all teams." );
        return teamService.getAll();
    }

    @GetMapping(value = { "/{id}", "/get/{id}" })
    public TeamDto getById(@PathVariable("id") Long id) {
        LOGGER.log( Level.INFO, "Getting team by id: " + id );
        return teamService.getById( id );
    }

    @DeleteMapping(value = { "/{id}", "/delete/{id}" })
    public void deleteById(@PathVariable("id") Long id) {
        LOGGER.log( Level.INFO, "Deleting team by id: " + id );
        teamService.deleteById( id );
    }

    @PostMapping(value = { "", "/", "/save" })
    public Long saveEmployee(@Valid @RequestBody SaveTeamDto dto) {
        LOGGER.log( Level.INFO, "Saving team: " + dto );
        return teamService.saveTeam( dto );
    }
}
