package com.hyper.employee.service.dto;

import lombok.Data;

@Data
public class SaveEmployeeDto {

    private Long   id;
    private String name;
    private Long   teamId;

    @Override
    public String toString() {
        return "SaveEmployeeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamId=" + teamId +
                '}';
    }
}
