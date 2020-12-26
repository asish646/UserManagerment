package com.user.management.serviceimpl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.management.model.User;
import com.user.management.repository.CityRepository;
import com.user.management.repository.CountryRepository;
import com.user.management.repository.StateRepository;
import com.user.management.repository.UserRepository;
import com.user.management.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CountryRepository countryRepo;
	@Autowired
	private StateRepository stateRepo;
	@Autowired
	private CityRepository cityRepo;
	
	private Map<Integer, String> countries;
	private Map<Integer, String> states;
	private Map<Integer, String> cities;
	
	@Override
	public Boolean registerUser(User user) {
		
		try {
			user.setPassword(UUID.randomUUID().toString().trim().substring(1,6));
			user.setAccessStatus("LOCK");
			
			userRepo.save(user);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public Map<Integer, String> getAllCountries() {

		countries = new HashMap<>();
		
		countryRepo.findAll().forEach(country ->{
			countries.put(country.getCountryId(), country.getCountryName());
		});
		
		return countries;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {

		states = new HashMap<Integer, String>();
		stateRepo.findBycountryId(countryId).forEach(state ->{
			states.put(state.getStateId(), state.getStateName());
		});
		return states;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
		
		cities = new HashMap<Integer, String>();
		cityRepo.findByStateId(stateId).forEach(city ->{
			cities.put(city.getCityId(), city.getCityName());
		});
		return cities;
	}

	@Override
	public Boolean isEmailUnique(String email) {

		return userRepo.findByEmail(email)!=null;
	}

	@Override
	public String login(String email, String password) {
		
		if( userRepo.findByEmailAndPassword(email, password) != null) {
			
			if(userRepo.findByEmailAndPassword(email, password).get(0).getAccessStatus().equals("LOCK")) {
				return "ACCOUNT LOCKED";
			}else {
				return "SUCCESS";
			}
		}else {
			return "INVALID CREDINTIALS";
		}
	}

	@Override
	public Boolean isTempPwdValid(String email, String tempPwd) {

		return userRepo.findByEmailAndPassword(email, tempPwd).get(0)!=null;
	}

	@Override
	public Boolean unlockUser(String email, String newPassword) {

		User user = userRepo.findByEmail(email).get(0);
		user.setPassword(newPassword);
		user.setAccessStatus("UNLOCK");
		
		try {
			userRepo.save(user);
		}catch(Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public String forgotPassword(String email) {

		if(userRepo.findByEmail(email).get(0)!=null) {
			return userRepo.findByEmail(email).get(0).getPassword();
		}else {
			return null;
		}
		
	}

}
