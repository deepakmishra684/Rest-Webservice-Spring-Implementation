package com.deepak.restapi.db;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.deepak.restapi.model.Message;
import com.deepak.restapi.model.User;

/**
 * @author deepak
 *
 */
public class MessengerDB {
	private static Map<Integer, Message> messengerMap = new HashMap<Integer, Message>();
	private static Map<Integer, User> userMap = new HashMap<Integer, User>();

	static {
		// Message DB
		Message message1 = new Message(new Long(1), "hello Deepak", new Date(), "Deepak");
		Message message2 = new Message(new Long(2), "hello Ankit", new Date(), "Ankit");
		Message message3 = new Message(new Long(3), "hello Abhilash", new Date(), "Abhilash");
		Message message4 = new Message(new Long(4), "hello Sumit", new Date(), "Sumit");
		Message message5 = new Message(new Long(5), "hello Chandu", new Date(), "Chandu");
		Message message6 = new Message(new Long(6), "hello Manish", new Date(), "Manish");
		Message message7 = new Message(new Long(7), "hello Sonu", new Date(), "Sonu");
		Message message8 = new Message(new Long(8), "hello Dharampal", new Date(), "Dharampal");
		Message message9 = new Message(new Long(9), "hello Amit", new Date(), "Amit");
		Message message10 = new Message(new Long(10), "hello Saharsh", new Date(), "Saharsh");
		messengerMap.put(1, message1);
		messengerMap.put(2, message2);
		messengerMap.put(3, message3);
		messengerMap.put(4, message4);
		messengerMap.put(5, message5);
		messengerMap.put(6, message6);
		messengerMap.put(7, message7);
		messengerMap.put(8, message8);
		messengerMap.put(9, message9);
		messengerMap.put(10, message10);

		// Messenger User DB
		User user1 = new User(1, "Deepak", "deepakmishra84@gmail.com", "Lucknow", 26);
		User user2 = new User(2, "Ankit", "ankitsing@gmail.com", "Urai", 25);
		User user3 = new User(3, "Abhilash", "abhilash@gmail.com", "Navada", 26);
		User user4 = new User(4, "Sumit", "sumit@gmail.com", "Kanpur", 25);
		User user5 = new User(5, "Chandu", "ckk@gmail.com", "Alahabad", 26);

		userMap.put(1, user1);
		userMap.put(2, user2);
		userMap.put(3, user3);
		userMap.put(4, user4);
		userMap.put(5, user5);

	}

	public static Map<Integer, Message> getMessengerMap() {
		return messengerMap;
	}

	public static void setMessengerMap(Map<Integer, Message> messengerMap) {
		MessengerDB.messengerMap = messengerMap;
	}

	public static Map<Integer, User> getUserMap() {
		return userMap;
	}

	public static void setUserMap(Map<Integer, User> userMap) {
		MessengerDB.userMap = userMap;
	}
}
