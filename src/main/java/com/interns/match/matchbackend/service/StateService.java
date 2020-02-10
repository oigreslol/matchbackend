package com.interns.match.matchbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.interns.match.matchbackend.model.dto.UpdateDto;
import com.interns.match.matchbackend.model.dto.UpdateDtoName;
import com.interns.match.matchbackend.model.entity.State;
import com.interns.match.matchbackend.model.repository.StateRepository;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> findStates() {
        return (List<State>) stateRepository.findAll();
    }

    public State findStateById(int id) {
        return stateRepository.findById(id).get();
    }
    
    public State createState(State state){
        return stateRepository.save(state);
    }

    public void deleteStateById(int id){
        stateRepository.deleteById(id);
    }

    public State updateStateByName(UpdateDtoName dto){
        State state = stateRepository.findByName(dto.getOldName());
        state.setName(dto.getNewName());
        return stateRepository.save(state);
    }

    public State updateStateById(UpdateDto dto){
        State state = stateRepository.findById(dto.getId()).get();
        state.setName(dto.getName());
        return stateRepository.save(state);
    }
}