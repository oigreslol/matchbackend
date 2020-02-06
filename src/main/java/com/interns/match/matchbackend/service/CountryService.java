package com.interns.match.matchbackend.service;

import java.util.List;

import com.interns.match.matchbackend.model.entity.Country;
import com.interns.match.matchbackend.model.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService{

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findCountries(){
        return countryRepository.findAll();
    }

}