package com.user.management.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.user.management.model.City;

public interface CityRepository extends CrudRepository<City, Integer> {

	List<City> findByStateId(Integer stateId);
}
