package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.grownited.entity.NewCityEntity;
import com.grownited.repository.CityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class NewCityController {
	@Autowired
	CityRepository repoCity;
	
	@GetMapping("newcity")
	public String newcity() {
		return "Newcity";
	}
	@PostMapping("savecity")
	public String savecity(NewCityEntity entityCity) {
		System.out.println(entityCity.getCityname());
		repoCity.save(entityCity);
		return "Newcity";
	}

}
