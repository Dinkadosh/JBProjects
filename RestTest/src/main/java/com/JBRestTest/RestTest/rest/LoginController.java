package com.JBRestTest.RestTest.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {
	
	@GetMapping
	public String login(@RequestParam ( name="email")String email,@RequestParam(name="password") String password) {
		if(email.equalsIgnoreCase("kobi@gmail.com") && password.equals("1234")) {
			return "Welcome Admin";
		}
		else if(email.equalsIgnoreCase("Avi@CocaCola.com") && password.equals("ColaAvi")) {
			return "Welcome Coca Cola company";
		}
		else if(email.equalsIgnoreCase("Michael@gmail.com") && password.equals("4321")) {
			return "Welcome Michael";
		}
		return "User not found";
	}

}

