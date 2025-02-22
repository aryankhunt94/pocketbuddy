package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.grownited.Service.MailService;
import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class SessionController {
	@Autowired
	MailService serviceMail;
	@Autowired
	UserRepository repositoryUser;
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping(value = {"/","signup"})
	public String signup() {
		return "Signup";
	}
	
	@GetMapping("login")
	public String login(String email,String password) {
		return "Login";
	}
	
	@PostMapping("saveuser")
	public String saveuser(UserEntity userEntity) {
		serviceMail.sendWelcomeMail(userEntity.getEmail(), userEntity.getFirstName());
		String encPassword =encoder.encode(userEntity.getPassword());
		userEntity.setPassword(encPassword);
		
		repositoryUser.save(userEntity);
		
		return "Signup";
	}
	
	//open forget password jsp
	@GetMapping("forgetpassword")
	public String forgetPassword() {
		return "ForgetPassword";
	}
	
	//submit forget password jsp and open changepassword jsp
	@PostMapping("sendOtp")
	public String SendOtp() {
		return "ChangePassword";
	}
	
	//change password jsp and open login page
	@PostMapping("updatepassword")
	public String UpdatePassword() {
		return "Login";
	}
	
	
}
