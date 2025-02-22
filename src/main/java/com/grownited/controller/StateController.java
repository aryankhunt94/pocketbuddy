package com.grownited.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class StateController {
	@GetMapping("newstate")
	public String newstate() {
		return "Newstate";
	}
	@PostMapping("savestate")
	public String savestate() {
		return "Savestate";
	}
}
