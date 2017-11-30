package com.deepak.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	UserService userService;

	/* ========= Find User Detail by User Id ============= */

	/*
	 * ResponseEntity:- is meant to represent the entire HTTP response. You can
	 * control anything that goes into it. : status code, headers, and body.
	 * 
	 * @ResponseBody:- is a marker for the HTTP response body
	 * and @ResponseStatus declares the status code of the HTTP response.
	 * 
	 * @ResponseStatus isn't very flexible. It marks the entire method so you
	 * have to be sure that your handler method will always behave the same way.
	 * And you still can't set the headers. You'd need the HttpServletResponse
	 * or a HttpHeaders parameter.
	 */

	/*
	 * It's a very common use case to have Controllers implement a REST API,
	 * thus serving only JSON, XML or custom MediaType content. For convenience,
	 * instead of annotating all your @RequestMapping methods with
	 * 
	 * @ResponseBody, you can annotate your Controller Class
	 * with @RestController. @RestController is a stereotype annotation that
	 * combines @ResponseBody and @Controller. More than that, it gives more
	 * meaning to your Controller and also may carry additional semantics in
	 * future releases of the framework.
	 */
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> findUserById(@PathVariable("userId") Integer userId) {
		User user = userService.userInfo(userId);
		if (user == null) {
			System.out.println("User with id :: " + userId + " NOT FOUND");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	/* ========= Find All User Detail ============= */

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<User>> findUsers() {
		List<User> user = userService.usersInfo();
		if (user.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}

	/* ========= Creating a User Detail ============= */

	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> createUser(@RequestBody User user) {

		User resulltUser = userService.createUser(user);
		return new ResponseEntity<User>(resulltUser, HttpStatus.CREATED);
	}

	/* ========= Updating User Detail by User Id ============= */

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> updateUser(@PathVariable("userId") Integer userId, @RequestBody User user) {
		User resulltUser = userService.updateUser(userId, user);
		if (resulltUser == null) {
			System.out.println("User with id " + userId + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(resulltUser, HttpStatus.OK);
	}

	/* ========= Deleting User Detail by User Id ============= */

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> deletUser(@PathVariable("userId") Integer userId) {
		User resulltUser = userService.userInfo(userId);

		if (resulltUser == null) {
			System.out.println("Unable to delete. User with id " + userId + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUser(userId);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
}
