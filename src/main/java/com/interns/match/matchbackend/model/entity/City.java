package com.interns.match.matchbackend.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CITIES")
@Data
public class City {
    @Id
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STATE")
    private int state;

}