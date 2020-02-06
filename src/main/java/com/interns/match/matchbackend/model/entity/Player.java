package com.interns.match.matchbackend.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import lombok.Data;

@Entity
@Table(name = "PLAYER")
@Data
public class Player{

    @Id
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "CITY")
    private int city;

}