package com.user.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "city_master")
@Data
@AllArgsConstructor
public class City {

	@Id
	@GeneratedValue
	@Column(name = "city_id")
	private Integer cityId;
	@Column(name = "city_name")
	private String cityName;
	@Column(name = "city_state_id")
	private Integer stateId;
}
