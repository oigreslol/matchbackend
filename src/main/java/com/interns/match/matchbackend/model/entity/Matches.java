package com.interns.match.matchbackend.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "MATCHES")
@Data
public class Matches{
    @Id
    private int id;

    @Column(name = "LOCAL_TEAM")
    private int localTeam;

    @Column(name = "VISITOR_TEAM")
    private int visitorTeam;

    @Column(name = "DATETIME")
    private Date dateStart;
    
}