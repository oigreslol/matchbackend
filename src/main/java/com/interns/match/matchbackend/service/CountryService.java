package com.interns.match.matchbackend.service;

import java.util.List;
import java.util.stream.Collectors;

import java.util.stream.StreamSupport;

import com.interns.match.matchbackend.model.dto.CreateCountryDto;
import com.interns.match.matchbackend.model.dto.UpdateDto;
import com.interns.match.matchbackend.model.dto.UpdateDtoName;
import com.interns.match.matchbackend.model.entity.Country;
import com.interns.match.matchbackend.model.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findCountries() {
        return StreamSupport.stream(countryRepository.findAll().spliterator(), false)
                            .collect(Collectors.toList());
    }

    public Country createCountry(CreateCountryDto countryDto) {
        Country country = new Country();
        country.setName(countryDto.getName());
        return countryRepository.save(country);
    }

    public Country findById(int id) {
        return countryRepository.findById(id).get();
    }

    public void deleteCountryById(int id){
        countryRepository.deleteById(id);
    }
    public void deleteCountryByName(String name){
        Country country = countryRepository.findByName(name);
        countryRepository.delete(country);
    }

    public Country updateCountryByName(UpdateDtoName dto){
        Country country = countryRepository.findByName(dto.getOldName());
        country.setName(dto.getNewName());
        return countryRepository.save(country);
    }

    public Country updateCountryById(UpdateDto dto){
        Country country = countryRepository.findById(dto.getId()).get();
        country.setName(dto.getName());
        return  countryRepository.save(country);
    }
}