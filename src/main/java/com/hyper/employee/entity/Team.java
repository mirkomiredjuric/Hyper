package com.hyper.employee.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "team")
public class Team extends BaseEntity{

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamLeadId")
    private Employee teamLead;
}
