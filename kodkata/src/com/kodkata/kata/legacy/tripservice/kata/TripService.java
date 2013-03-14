package com.kodkata.kata.legacy.tripservice.kata;

import java.util.List;

public class TripService {

	public List<Trip> getTripsByUser(User user, User loggedUser) throws UserNotLoggedInException {
		validateUser(loggedUser);
		return user.isFriend(loggedUser) ? findTripsByUser(user) : null;
	}

	private List<Trip> findTripsByUser(User user) {
		return TripDAO.findTripsByUser(user);
	}

	private void validateUser(User loggedUser) throws UserNotLoggedInException {
		if (loggedUser == null)
			throw new UserNotLoggedInException();
	}
}
