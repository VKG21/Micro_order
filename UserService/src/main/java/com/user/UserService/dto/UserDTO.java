package com.user.UserService.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserDTO {

	@Id
	@Column(name = "user_id")
	@SequenceGenerator(initialValue = 1000, allocationSize = 1, name = "user_sequence", sequenceName = "partner_sequence")
	@GeneratedValue(generator = "user_sequence")
	private long userId;

	private String userName;

	private String city;

	private String userMobNum;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUserMobNum() {
		return userMobNum;
	}

	public void setUserMobNum(String userMobNum) {
		this.userMobNum = userMobNum;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", city=" + city + ", userMobNum=" + userMobNum
				+ "]";
	}

}
