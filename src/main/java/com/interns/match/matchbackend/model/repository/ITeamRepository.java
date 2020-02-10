package com.interns.match.matchbackend.model.repository;

import com.interns.match.matchbackend.model.entity.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamRepository extends CrudRepository<Team, Integer> {
}
