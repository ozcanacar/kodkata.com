package com.kodkata.kata.legacy.tripservice.kata2;

import java.util.List;

public class User {

	public List<User> getFriends() {
		// TODO Auto-generated method stub
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
