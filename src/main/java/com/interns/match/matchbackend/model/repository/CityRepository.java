package com.interns.match.matchbackend.model.repository;

import com.interns.match.matchbackend.model.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends CrudRepository<City,Integer>{
    City findByName(@Param("name") String name);
}