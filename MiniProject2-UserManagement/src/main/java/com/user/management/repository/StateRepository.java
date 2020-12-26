package com.user.management.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.user.management.model.State;

public interface StateRepository extends CrudRepository<State, Integer> {

	public List<State> findBycountryId(Integer Countryid);
}
