package com.grownited.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class StateController {
	@GetMapping("statecontroller")
	public String statecontroller() {
		return "Newstate";
	}
}
