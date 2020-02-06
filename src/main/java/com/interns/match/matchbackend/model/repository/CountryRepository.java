package com.interns.match.matchbackend.model.repository;

import com.interns.match.matchbackend.model.entity.Country;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Integer>{}