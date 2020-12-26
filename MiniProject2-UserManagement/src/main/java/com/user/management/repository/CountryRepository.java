package com.user.management.repository;

import org.springframework.data.repository.CrudRepository;

import com.user.management.model.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {

}
