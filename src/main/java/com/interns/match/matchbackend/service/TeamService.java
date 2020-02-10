package com.interns.match.matchbackend.service;

import com.interns.match.matchbackend.model.entity.Team;
import com.interns.match.matchbackend.model.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TeamService {

    @Autowired
    private ITeamRepository teamRepository;

    public List<Team> findAll(){
        return StreamSupport
                .stream(teamRepository
                            .findAll()
                            .spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<Team> findById(int id) throws Exception{
        return Optional
                .ofNullable(teamRepository.findById(id)).get();
    }
}
