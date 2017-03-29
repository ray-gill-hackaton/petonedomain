package com.tim.pet.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableAutoConfiguration
@Controller
public class AuthController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

	@RequestMapping(path="/api/user", method=RequestMethod.GET)
	@CrossOrigin
	@ResponseBody
	public Principal user(Principal user) {
		LOGGER.info("Requesting principal {}", user);
		return user;
	}
	
	@RequestMapping(path="/api/signout", method=RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public void signout() {
		LOGGER.info("Signing out");
		SecurityContextHolder.clearContext();
	}


}
