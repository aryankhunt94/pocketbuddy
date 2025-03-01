package com.grownited.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.grownited.Service.MailService;
import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

import jakarta.mail.Session;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





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
		
		userEntity.setRole("USER");
		
		repositoryUser.save(userEntity);
		
		return "Signup";
	}
	@PostMapping("authenticate")
	public String authenticate(String email,String password,Model model,HttpSession session) {
		System.out.println(email);
		System.out.println(password);
		
		Optional<UserEntity> op =repositoryUser.findByEmail(email);
		
		if (op.isPresent()) {
			UserEntity dbUser =op.get();
			
			boolean ans =encoder.matches(password, dbUser.getPassword());
			
			if(ans == true){
				session.setAttribute("user", dbUser);
				if (dbUser.getRole().equals("ADMIN")) {
					
					return "redirect:/admindashboard";
				} 
				else if (dbUser.getRole().equals("USER")) {
					
					return "redirect:/home";
				} else {
					model.addAttribute("error", "Please contact Admin with Error Code #0991");
					return "Login";
				}

			}
		}
		return "Login";
	}
	
	public String authenticart;
	
	
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

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";// login url
	}
	
}
