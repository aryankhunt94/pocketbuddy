package com.grownited.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.grownited.entity.MemberEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.MemberRepository;

import jakarta.mail.Session;
import jakarta.servlet.http.HttpSession;

@Controller
public class Membercontroller {
	
	@Autowired
	MemberRepository repoMember;
	
	@GetMapping("newmember")
	public String newMember() {
		return "Newmember";
	}
	
	@PostMapping("savemember")
	public String saveMember(MemberEntity entityMember,HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId(); 
		entityMember.setUserId(userId);
		
		repoMember.save(entityMember);
		return "Newmember"; 
	}
	
	
	@GetMapping("listmember")
	public String listMembere(Model model) {
		List<MemberEntity> memberList =repoMember.findAll();   //fetch the data
		model.addAttribute("memberList", memberList);
		return "ListMember";
		
	}
	@GetMapping("viewmember")
	public String viewMember(Integer memberId,Model model) {
		
		Optional<MemberEntity> op = repoMember.findById(memberId);
		System.out.println("id===>"+memberId);
		if (op.isEmpty()) {
			
		} else {
			
			MemberEntity member = op.get();
			
			model.addAttribute("member", member);

		}

		return "ViewMember";
	}
	@GetMapping("deletemember")
	public String deleteMember(Integer memberId) {
		repoMember.deleteById(memberId);//delete from members where memberID = :memberId
		return "redirect:/listmember";
	}
	
	
	
}
