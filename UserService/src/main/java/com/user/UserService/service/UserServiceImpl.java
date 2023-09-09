package com.user.UserService.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.UserService.dto.OrderDTO;
import com.user.UserService.dto.ProductDTO;
import com.user.UserService.dto.UserDTO;
import com.user.UserService.exception.handler.ResourceNotFoundException;
import com.user.UserService.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public UserDTO saveUser(UserDTO userdto) {
		return userRepository.save(userdto);
	}

	public List<UserDTO> getAllUser() {
		return userRepository.findAll();
	}

	public void deleteUser(long userId) {
		UserDTO dto = userRepository.findByuserId(userId);

		if ((dto == null)) {
			throw new ResourceNotFoundException("User", "Id", userId);
		} else {
			userRepository.delete(dto);
		}

	}

	@Override
	public List<UserDTO> getAllServiceUser() {
		List<UserDTO> users = null;
		try {
			List<UserDTO> usersmulti = userRepository.findAll();
			
			if (usersmulti != null) {
				for (UserDTO userDTO : usersmulti) {
					OrderDTO[] listOfOrder = restTemplate.getForObject(
							"http://localhost:9093/order/getOrder/" + userDTO.getUserId(), OrderDTO[].class);
					List<OrderDTO> list = Arrays.stream(listOfOrder).toList();
				

					for (OrderDTO order : list) {
						ProductDTO[] product = restTemplate.getForObject(
								"http://localhost:9093/order/getOrder/" + order.getProductId(), ProductDTO[].class);

						List<ProductDTO> products = Arrays.stream(product).toList();

					}
					
				}
				
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
