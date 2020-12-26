package com.user.management.service;

import java.util.Map;

import com.user.management.model.City;
import com.user.management.model.Country;
import com.user.management.model.State;
import com.user.management.model.User;

public interface IUserService {

	//Register Screen
	public Boolean registerUser(User user);
	public Map<Integer, String> getAllCountries();
	public Map<Integer, String> getStates(Integer countryId);
	public Map<Integer, String> getCities(Integer stateId);
	public Boolean isEmailUnique(String email);
	
	//Login Screen
	public String login(String email, String password);
	
	//UnlockAccount Screen
	public Boolean isTempPwdValid(String email, String tempPwd);
	public Boolean unlockUser(String email, String newPassword);
	
	//ForgetPassword Screen
	public String forgotPassword(String emial);
	
}
