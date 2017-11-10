package com.deepak.restapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author deepak
 *
 */

/*
 * JAXB : Is the annotation @XmlAccessorType is only for Serialization and
 * nothing to do with Binding of data
 */
/* Controls whether fields or Javabean properties are serialized by default. */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class User {

	private Integer userId;
	private String userName;
	private String emailId;
	private String address;
	private Integer age;

	public User() {
		super();
	}

	public User(Integer userId, String userName, String emailId, String address, Integer age) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.address = address;
		this.age = age;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
