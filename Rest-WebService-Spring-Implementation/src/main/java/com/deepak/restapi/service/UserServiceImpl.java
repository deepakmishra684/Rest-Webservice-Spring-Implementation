package com.deepak.restapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.deepak.restapi.db.MessengerDB;
import com.deepak.restapi.model.User;

/**
 * @author deepak
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	public User userInfo(Integer id) {
		return MessengerDB.getUserMap().get(id);
	}

	public List<User> usersInfo() {
		List<User> userList = new ArrayList<User>();
		Set<Entry<Integer, User>> set = MessengerDB.getUserMap().entrySet();
		for (Entry<Integer, User> entry : set) {
			userList.add(entry.getValue());
		}
		return userList;
	}

	public User createUser(User user) {
		int size = MessengerDB.getUserMap().size() + 1;
		user.setUserId(size);
		MessengerDB.getUserMap().put(size, user);
		return user;
	}

	public User updateUser(Integer userId, User user) {

		User userNew = new User(user.getUserId(), user.getUserName(), user.getAddress(), user.getAddress(),
				user.getAge());
		MessengerDB.getUserMap().put(userId, userNew);

		return MessengerDB.getUserMap().get(userId);
	}

	public void deleteUser(Integer userId) {

		MessengerDB.getUserMap().remove(userId);
	}

}
