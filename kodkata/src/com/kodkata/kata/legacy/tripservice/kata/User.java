package com.kodkata.kata.legacy.tripservice.kata;

import java.util.List;

public class User {

	public List<User> getFriends() {
		return null;
	}

	boolean isFriend(User loggedUser) {
		boolean isFriend = false;
		for (User friend : getFriends()) {
			if (friend.equals(loggedUser)) {
				isFriend = true;
				break;
			}
		}
		return isFriend;
	}
}
