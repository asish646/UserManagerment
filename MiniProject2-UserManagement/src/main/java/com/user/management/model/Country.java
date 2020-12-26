package com.user.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "country_master")
@AllArgsConstructor
@Data
public class Country {

	@Id
	@GeneratedValue
	@Column(name = "contr_id")
	private Integer countryId;
	@Column(name = "contr_name")
	private String countryName;
}
