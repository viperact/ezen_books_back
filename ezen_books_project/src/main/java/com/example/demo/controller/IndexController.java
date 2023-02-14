package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.login.dto.User;
import com.example.demo.login.repository.UserRepository;


@CrossOrigin("*")

@RestController
public class IndexController {
	
	@Autowired
	private BCryptPasswordEncoder encodePassWord;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/RegisterPage")
	public String join(@RequestBody User user) {
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		System.out.println(user.getAuthRole());
		user.setPassword(encodePassWord.encode(user.getPassword()));
		userRepository.saveUser(user);
		
		return "회원가입완료";
	}


}
