package com.grownited.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.StateEntity;
import com.grownited.repository.StateRepository;
@Controller
public class StateController {
	
	@Autowired
	StateRepository repoState;
	
	@GetMapping("newstate")
	public String newState() {
		return "Newstate";
	}
	@PostMapping("savestate")
	public String saveState(StateEntity State) {
		System.out.println(State.getStateName());
		repoState.save(State);
		return "Newstate";
	}
}
