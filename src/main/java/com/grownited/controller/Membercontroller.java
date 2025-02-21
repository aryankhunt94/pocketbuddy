package com.grownited.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.grownited.entity.MemberEntity;
import com.grownited.repository.MemberRepository;

@Controller
public class Membercontroller {
	
	@Autowired
	MemberRepository repoMember;
	
	@GetMapping("newmember")
	public String newMember() {
		return "Newmember";
	}
	
	@PostMapping("savemember")
	public String saveMember(MemberEntity entityMember) {
		repoMember.save(entityMember);
		return "Newmember";
	}
	
	
	@GetMapping("listmember")
	public String listMembere(Model model) {
		List<MemberEntity> memberList =repoMember.findAll();   //fetch the data
		model.addAttribute("memberList", memberList);
		return "ListMember";
		
	}
	
	
	
}
