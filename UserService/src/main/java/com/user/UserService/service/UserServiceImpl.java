package com.user.UserService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.UserService.dto.UserDTO;
import com.user.UserService.exception.handler.ResourceNotFoundException;
import com.user.UserService.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public UserDTO saveUser(UserDTO userdto) {
		return userRepository.save(userdto);
	}

	public List<UserDTO> getAllUser() {
		return userRepository.findAll();
	}

	public void  deleteUser(long userId) {
		UserDTO dto=userRepository.findByuserId(userId);
		
		if ((dto==null)) {
			throw new ResourceNotFoundException("User", "Id", userId);
		}
		else {
			userRepository.delete(dto);
		}
				
		
		
	}

	

}
