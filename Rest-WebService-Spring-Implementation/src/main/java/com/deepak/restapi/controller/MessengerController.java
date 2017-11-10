package com.deepak.restapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.restapi.model.User;
import com.deepak.restapi.service.UserService;

/**
 * @author deepak
 *
 */
@RestController
@RequestMapping("/rest")
public class MessengerController {

	/* ========= Find User Detail by User Id ============= */

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> findUserById(@PathVariable("userId") Integer userId) {
		User user = UserService.userInfo(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	/* ========= Find All User Detail ============= */

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<User>> findUsers() {
		List<User> user = UserService.usersInfo();
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}

	/* ========= Creating a User Detail ============= */

	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User resulltUser = UserService.createUser(user);
		return new ResponseEntity<User>(resulltUser, HttpStatus.OK);
	}

	/* ========= Updating User Detail by User Id ============= */

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> updateUser(@PathVariable("userId") Integer userId, @RequestBody User user) {
		User resulltUser = UserService.updateUser(userId, user);
		return new ResponseEntity<User>(resulltUser, HttpStatus.OK);
	}

	/* ========= Deleting User Detail by User Id ============= */

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<User>> deletUser(@PathVariable("userId") Integer userId) {
		List<User> resulltUser = UserService.deleteUser(userId);
		return new ResponseEntity<List<User>>(resulltUser, HttpStatus.OK);
	}
}
