package com.grownited.controller.Admin;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.NewCityEntity;
import com.grownited.entity.StateEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.StateRepository;


@Controller
public class CityController {
	@Autowired
	StateRepository repoState;
	
	@Autowired
	CityRepository repoCity;
	
	@GetMapping("newcity")
	public String newcity(Model model) {
		List<StateEntity> allstate = repoState.findAll();
		model.addAttribute("allstate",allstate);
		return "Newcity";
	
		
	}
	@PostMapping("savecity")
	public String saveCity(NewCityEntity entityCity) {
		repoCity.save(entityCity);
		return "redirect:/newcity";
	}
}



