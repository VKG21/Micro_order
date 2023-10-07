package com.user.UserService.service;

import java.util.Arrays;
import java.util.HashMap;
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

	UserDTO listofdata = new UserDTO();

	List<UserDTO> users = null;

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
	public UserDTO getAllServiceUser(long userId) {

		UserDTO dto = userRepository.findByuserId(userId);

		try {
			if ((dto == null)) {
				throw new ResourceNotFoundException("User", "Id", userId);
			} else {
				OrderDTO[] listOfOrder = restTemplate
						.getForObject("http://localhost:9093/order/getOrder/" + dto.getUserId(), OrderDTO[].class);
				List<OrderDTO> list = Arrays.stream(listOfOrder).toList();
				// listofdata.setOrders(list);
				dto.setOrders(list);
				for (OrderDTO order : list) {

					List<ProductDTO> product = restTemplate.getForObject(
							"http://localhost:9092/product/get/" + order.getProductId(), List.class);

					//List<ProductDTO> products = Arrays.stream(product).toList();
					dto.setProducts(product);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return  dto;

	}
}
