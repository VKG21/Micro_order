package com.user.UserService.service;

import java.util.List;

import com.user.UserService.dto.UserDTO;

public interface UserService {

	UserDTO saveUser(UserDTO userdto);

	List<UserDTO> getAllUser();

	void deleteUser(long userId);

	

}
