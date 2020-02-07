package com.interns.match.matchbackend.service;

import com.interns.match.matchbackend.model.dto.CityDto;
import com.interns.match.matchbackend.model.entity.City;
import com.interns.match.matchbackend.model.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> findCities() {
        return StreamSupport.stream(cityRepository.findAll().spliterator(), false)
                            .collect(Collectors.toList());
    }
    
    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public Optional<City> findOneCity(City city) {
        return cityRepository.findById(city.getId());
    }

    public void deleteCityById(int id){
        cityRepository.deleteById(id);
    }
    public void deleteCityByName(String name){
        City city = cityRepository.findByName(name);
        cityRepository.delete(city);
    }

    public City updateCityByName(CityDto dto){
        City city = cityRepository.findByName(dto.getName());
        city.setState(dto.getState());
        return  cityRepository.save(city);
    }

    public City updateCityById(CityDto dto){
        City city = cityRepository.findById(dto.getId()).get();
        city.setName(dto.getName());
        city.setState(dto.getState());
        return  cityRepository.save(city);
    }
}