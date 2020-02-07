package com.interns.match.matchbackend.controller;

import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

import com.interns.match.matchbackend.model.dto.UpdateDto;
import com.interns.match.matchbackend.model.dto.UpdateDtoName;
import com.interns.match.matchbackend.model.entity.Country;
import com.interns.match.matchbackend.service.CountryService;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class MainController{

    @Autowired
    private CountryService countryService;

    @GetMapping(path = "/")
    public String requestMethodName() {
        return new String("MatchBACKEND WELCOMER");
    }

    @GetMapping(path="/country/all")
    public List<Country> getAllCountries() {
        return countryService.findCountries();
    }

    @GetMapping(path = "/country/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Country> findById(@PathVariable(value = "id") int id) throws Exception {
        return ResponseEntity.ok(
        Optional.ofNullable(countryService.findById(id))
                                        .orElseThrow(() -> new Exception("No Match Found")));
    }

    @PostMapping(path="/country/create")
    public Country createCountry(@RequestBody Country country) {
        country = countryService.createCountry(country);
        System.out.println(country);
        return country;
    }
    
    @RequestMapping(path="/country/deletebyid/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteCountryById(@PathVariable(value = "id") int id) {
        countryService.deleteCountryById(id);
        return HttpStatus.OK;
    }

    @RequestMapping(path = "/country/deletebyname", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCountryByName(@RequestBody String name){
        try {
            countryService.deleteCountryByName(name);
            return ResponseEntity.ok("Good");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @RequestMapping(path="/country/updatebyid", method = RequestMethod.PUT)
    public Country updateCountryById(@RequestBody UpdateDto dto) {
        return countryService.updateCountryById(dto);
    }

    @RequestMapping(path="/country/updatebyname", method = RequestMethod.PUT)
    public Country updateCountryByName(@RequestBody UpdateDtoName dto) {
        return countryService.updateCountryByName(dto);
    }
}