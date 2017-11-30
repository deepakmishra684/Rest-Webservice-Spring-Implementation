package com.deepak.restapi.service;

import java.util.List;

import com.deepak.restapi.model.User;

public interface UserService {
	User userInfo(Integer id);

	List<User> usersInfo();

	User createUser(User user);

	User updateUser(Integer userId, User user);

	void deleteUser(Integer userId);
}
