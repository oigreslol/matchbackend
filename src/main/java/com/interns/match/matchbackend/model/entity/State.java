package com.interns.match.matchbackend.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "STATE")
@Data
public class State{
    @Id
    private int id;

    @Column(name ="NAME")
    private String name;

    @Column(name = "COUNTRY")
    private int country;
}