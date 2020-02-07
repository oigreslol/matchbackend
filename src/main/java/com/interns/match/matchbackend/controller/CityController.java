package com.interns.match.matchbackend.controller;

import com.interns.match.matchbackend.model.dto.CityDto;
import com.interns.match.matchbackend.model.entity.City;
import com.interns.match.matchbackend.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CityController {

    @Autowired
    private CityService cityService;


    @GetMapping(path="/city/all")
    public List<City> getAllCountries() {
        return cityService.findCities();
    }

    @PostMapping(path="/city/create")
    public City createCity(@RequestBody City city) {
        city = cityService.createCity(city);
        System.out.println(city);
        return city;
    }

    @GetMapping(path = "/city/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> findById(@PathVariable(value = "id") int id) throws Exception {
        return ResponseEntity.ok(
        Optional.ofNullable(cityService.findById(id))
                                        .orElseThrow(() -> new Exception("No Match Found")));
    }
    
    @RequestMapping(path="/city/deletebyid", method = RequestMethod.DELETE)
    public HttpStatus deleteCityById(@RequestBody int id) {
        cityService.deleteCityById(id);
        return HttpStatus.OK;
    }

    @RequestMapping(path="/city/deletebyname", method = RequestMethod.DELETE)
    public HttpStatus deleteCityByName(@RequestBody String name) {
        cityService.deleteCityByName(name);
        return HttpStatus.OK;
    }


    @RequestMapping(path="/city/updatebyid", method = RequestMethod.PUT)
    public City updateCityById(@RequestBody CityDto dto) {
        return cityService.updateCityById(dto);
    }

    @RequestMapping(path="/city/updatebyname", method = RequestMethod.PUT)
    public City updateCityByName(@RequestBody CityDto dto) {
        return cityService.updateCityByName(dto);
    }
}