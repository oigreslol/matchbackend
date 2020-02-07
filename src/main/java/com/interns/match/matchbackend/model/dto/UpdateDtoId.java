package com.interns.match.matchbackend.model.dto;

import lombok.Data;

@Data
public class UpdateDtoId{

    private int id;
    private String oldName;
    private String newName;
}