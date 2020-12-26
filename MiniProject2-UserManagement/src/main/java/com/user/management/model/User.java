package com.user.management.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "user_tab")
@Data
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usr_id_col")
	private Integer userId;
	@Column(name = "usr_first_name_col")
	private String firstName;
	@Column(name = "usr_last_name_col")
	private String lastName;
	@Column(name = "usr_email_col", unique = true)
	private String email;
	@Column(name = "usr_phone_no_col")
	private String phoneNo;
	@Column(name = "usr_dob_col")
	private Date dob;
	@Column(name = "usr_gender_col")
	private String gender;
	@Column(name = "usr_country_col")
	private String country;
	@Column(name = "usr_state_col")
	private String state;
	@Column(name = "usr_city_col")
	private String city;
	
	@Column(name = "usr_password_col")
	private String password;
	@Column(name = "usr_access_stats_col")
	private String accessStatus;
	
	
}
