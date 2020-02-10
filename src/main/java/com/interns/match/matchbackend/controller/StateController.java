package com.interns.match.matchbackend.controller;

import java.util.List;
import java.util.Optional;

import com.interns.match.matchbackend.model.dto.UpdateDto;
import com.interns.match.matchbackend.model.dto.UpdateDtoName;
import com.interns.match.matchbackend.model.entity.State;
import com.interns.match.matchbackend.service.StateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
public class StateController {

    @Autowired
    private StateService stateService;


    @GetMapping(path="/state/all")
    public List<State> getAllCountries() {
        return stateService.findStates();
    }

    @GetMapping(path="/state/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<State> findById(@PathVariable(value = "id") int id) throws Exception {
        return ResponseEntity.ok(
            Optional.ofNullable(stateService.findStateById(id))
                .orElseThrow(() -> new Exception("No State Found"))
        );
    }

    @PostMapping(path="/state/create")
    public ResponseEntity<State> createState(@RequestBody State state) {
        return ResponseEntity.ok(stateService.createState(state));
    }

    @RequestMapping(path="/state/deletebyid/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteStateById(@PathVariable(value = "id") int id) {
        try {
            stateService.deleteStateById(id);
            return ResponseEntity.ok("200: Deleted Completely");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(path="/state/updatename", method = RequestMethod.PUT)
    public State updateCountryByName(@RequestBody UpdateDtoName dto) {
        return stateService.updateStateByName(dto);
    }

    
    @RequestMapping(path="/state/updateid", method = RequestMethod.PUT)
    public ResponseEntity<State> updateStateByID(@RequestBody UpdateDto dto) throws Exception {
        return ResponseEntity.ok(
            Optional.ofNullable(stateService.updateStateById(dto))
                    .orElseThrow(() -> new Exception("No Match Found")));
    }
}