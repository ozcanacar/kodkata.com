package com.kodkata.kata.legacy.tripservice.kata2;

import java.util.ArrayList;
import java.util.List;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		User loggedUser = getLoggedUser();
		validateUser(loggedUser);
		return user.isFriend(loggedUser) ? findUser(user) : new ArrayList<Trip>();

	}

	private List<Trip> findUser(User user) {
		return TripDAO.findTripsByUser(user);
	}

	private void validateUser(User loggedUser) throws UserNotLoggedInException {
		if (loggedUser == null) {
			throw new UserNotLoggedInException();
		}
	}

	private User getLoggedUser() {
		return UserSession.getInstance().getLoggedUser();
	}
}
