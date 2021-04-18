package com.hyper.employee.service.dto;

import lombok.Data;

@Data
public class SaveTeamDto {

    private Long   id;
    private String name;
    private Long   teamLeadId;

    @Override
    public String toString() {
        return "SaveTeamDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamLeadId=" + teamLeadId +
                '}';
    }

}
