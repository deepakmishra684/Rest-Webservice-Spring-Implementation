package com.deepak.restapi.model;

import java.util.Date;

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
public class Message {

	private Long messageid;
	private String message;
	private Date created;
	private String person;

	public Message() {
	}

	public Message(Long messageid, String message, Date created, String person) {
		super();
		this.messageid = messageid;
		this.message = message;
		this.created = created;
		this.person = person;
	}

	public Long getMessageid() {
		return messageid;
	}

	public void setMessageid(Long messageid) {
		this.messageid = messageid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}
}
