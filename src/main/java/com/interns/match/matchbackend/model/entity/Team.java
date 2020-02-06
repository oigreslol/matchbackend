package com.interns.match.matchbackend.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TEAM")
@Data
public class Team{

    @Id
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CITY")
    private int city;

}