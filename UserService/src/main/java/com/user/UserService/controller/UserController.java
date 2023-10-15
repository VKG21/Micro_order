package com.user.UserService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.UserService.dto.UserDTO;
import com.user.UserService.playload.ApiResponse;
import com.user.UserService.service.UserService;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

	@Autowired
	UserService userService;
	
	@Value("${test.user}")
    private String user;
	
	@PostMapping("/createUser")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userdto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userdto));

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<UserDTO>> getAllUser() {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.getAllUser());

	}
	
	@GetMapping("/getUserByOrderByProduct/{userId}")
	public ResponseEntity<UserDTO> getAllUserAndProdcutWithOrder(@PathVariable long userId) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.getAllServiceUser(userId));

	}

	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<ApiResponse> userdelete(@PathVariable long userId) {
		System.out.println(user);
		userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);

	}
	


}
