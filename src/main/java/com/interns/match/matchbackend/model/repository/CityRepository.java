package com.interns.match.matchbackend.model.repository;

import com.interns.match.matchbackend.model.entity.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CountryRepository extends CrudRepository<Country,Integer>{
    Country findByName(@Param("name") String name);
}