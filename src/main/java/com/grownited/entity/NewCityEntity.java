package com.grownited.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "city")
public class NewCityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CityId;
	private String  cityname;
	public Integer getcityId() {
		return CityId;
	}
	public void setCityId(Integer cityId) {
		CityId = cityId;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	
	
	
}
