package com.interns.match.matchbackend.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "COUNTRIES")
@Data
public class Country{
    @Id
    private int id;

    @Column(name = "NAME")
    private String name;

}