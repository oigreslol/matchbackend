package com.interns.match.matchbackend.controller;

import com.interns.match.matchbackend.model.dto.CityDto;
import com.interns.match.matchbackend.model.entity.City;
import com.interns.match.matchbackend.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CityController {

    @Autowired
    private CityService cityService;


    @GetMapping(value="/city/all")
    public List<City> getAllCountries() {
        return cityService.findCities();
    }

    @PostMapping(value="/city/create")
    public City createCity(@RequestBody City city) {
        city = cityService.createCity(city);
        System.out.println(city);
        return city;
    }
    
    @RequestMapping(value="/city/deletebyid", method = RequestMethod.DELETE)
    public HttpStatus deleteCityById(@RequestBody int id) {
        cityService.deleteCityById(id);
        return HttpStatus.OK;
    }

    @RequestMapping(value="/city/deletebyname", method = RequestMethod.DELETE)
    public HttpStatus deleteCityByName(@RequestBody String name) {
        cityService.deleteCityByName(name);
        return HttpStatus.OK;
    }


    @RequestMapping(value="/city/updatebyid", method = RequestMethod.PUT)
    public City updateCityById(@RequestBody CityDto dto) {
        return cityService.updateCityById(dto);
    }

    @RequestMapping(value="/city/updatebyname", method = RequestMethod.PUT)
    public City updateCityByName(@RequestBody CityDto dto) {
        return cityService.updateCityByName(dto);
    }

    
    
    
    
}