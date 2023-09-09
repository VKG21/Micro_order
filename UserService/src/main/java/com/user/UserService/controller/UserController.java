package com.user.UserService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/createUser")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userdto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userdto));

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<UserDTO>> getAllUser() {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.getAllUser());

	}
	
	@GetMapping("/getAllUserByOrderByProduct")
	public ResponseEntity<List<UserDTO>> getAllUserAndProdcutWithOrder() {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.getAllServiceUser());

	}

	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<ApiResponse> userdelete(@PathVariable long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);

	}
	
	//user by id//get product //order details

}
