package com.interns.match.matchbackend.model.repository;


import com.interns.match.matchbackend.model.entity.Player;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends CrudRepository<Player,Integer>{
    Player findByName(@Param("name") String name);
    Iterable<Player> findByCountry(@Param("country") int country);
}