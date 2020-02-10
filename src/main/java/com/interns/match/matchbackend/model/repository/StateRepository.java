package com.interns.match.matchbackend.model.repository;

import com.interns.match.matchbackend.model.entity.State;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StateRepository extends CrudRepository<State,Integer>{
    State findByName(@Param("name") String name);
}