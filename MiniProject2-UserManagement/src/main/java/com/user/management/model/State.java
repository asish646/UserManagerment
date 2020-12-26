package com.user.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "state_master")
@Data
@AllArgsConstructor
public class State {

	@Id
	@GeneratedValue
	@Column(name = "stat_id")
	private Integer stateId;
	@Column(name = "stat_name")
	private String stateName;
	@Column(name = "stat_contr_id")
	private Integer countryId;
}
