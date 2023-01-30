package com.ajudaqui.myappface.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ajudaqui.myappface.model.Users;
import com.ajudaqui.myappface.service.UsersService;
import com.ajudaqui.myappface.service.request.Login;
import com.ajudaqui.myappface.service.request.UsersCreated;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersServie;
	
	@PostMapping("/registred")
//	@PostMapping()
	public Users registred(@RequestBody UsersCreated usersCreated) {
		Users usersRegistred = usersServie.registered(usersCreated);
		System.err.println("O registro deu certo! ");
		return usersRegistred;
		
	}
	@GetMapping(value= "/name/{name}")
	public Users findByName(@RequestParam String name) {
		Users user = usersServie.findByName(name);
		
		return user;
	}
	
	@PostMapping(value="/login")
	public void login(@RequestBody Login login) {
		usersServie.login(login);
	}
	

}
