package com.interns.match.matchbackend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import com.interns.match.matchbackend.model.entity.Country;
import com.interns.match.matchbackend.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class MainController{

    @Autowired
    private CountryService countryService;

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String requestMethodName() {
        return new String("Hola");
    }

    @GetMapping(value="/countries")
    public List<Country> getCountries() {
        return countryService.findCountries();
    }
    
    
}