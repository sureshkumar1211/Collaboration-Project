package com.suresh.backendserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.backendserver.dao.UserDAO;
import com.suresh.backendserver.model.UserCredentials;

@RestController
public class UserController {

	@Autowired
	UserDAO userDAO;

	@PostMapping(value= {"/user"})
	public ResponseEntity<String> registerUser(@RequestBody UserCredentials userCredentials) {
		if (userDAO.registerUser(userCredentials)) {
			System.out.println("user created");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("user not created");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

}
