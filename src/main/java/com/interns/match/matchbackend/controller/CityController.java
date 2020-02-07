package com.interns.match.matchbackend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import com.interns.match.matchbackend.model.dto.UpdateDto;
import com.interns.match.matchbackend.model.dto.UpdateDtoName;
import com.interns.match.matchbackend.model.entity.Country;
import com.interns.match.matchbackend.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class MainController{

    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/")
    public String requestMethodName() {
        return new String("MatchBACKEND WELCOMER");
    }

    @GetMapping(value="/country/all")
    public List<Country> getAllCountries() {
        return countryService.findCountries();
    }

    @PostMapping(value="/country/create")
    public Country createCountry(@RequestBody Country country) {
        country = countryService.createCountry(country);
        System.out.println(country);
        return country;
    }
    
    @RequestMapping(value="/country/deletebyid", method = RequestMethod.DELETE)
    public HttpStatus deleteCountryById(@RequestBody int id) {
        countryService.deleteCountryById(id);
        return HttpStatus.OK;
    }

    @RequestMapping(value="/country/deletebyname", method = RequestMethod.DELETE)
    public HttpStatus deleteCountryByName(@RequestBody String name) {
        countryService.deleteCountryByName(name);
        return HttpStatus.OK;
    }


    @RequestMapping(value="/country/updatebyid", method = RequestMethod.PUT)
    public Country updateCountryById(@RequestBody UpdateDto dto) {
        return countryService.updateCountryById(dto);
    }

    @RequestMapping(value="/country/updatebyname", method = RequestMethod.PUT)
    public Country updateCountryByName(@RequestBody UpdateDtoName dto) {
        return countryService.updateCountryByName(dto);
    }

    
    
    
    
}