package com.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/myapp")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Q-17
	@PostMapping(value="/user", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void registerUser(@RequestBody UserEntity user) {
		userService.registerUser(user);
	}
	
	//Q-1
	@PostMapping(value="/user/login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String login(@RequestBody UserEntity user) {
		return userService.login(user);
	}
	
	//Q-18
	@GetMapping(value="/user/{userId}")
	public UserEntity userInfo(@PathVariable(name="userId") long userId) {
		return userService.userInfo(userId);
	}
	
}
