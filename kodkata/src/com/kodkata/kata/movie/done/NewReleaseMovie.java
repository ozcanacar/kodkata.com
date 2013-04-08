package com.kodkata.kata.movie.done;


public class NewReleaseMovie extends Movie {

	public NewReleaseMovie(String title) {
		super(title, NEW_RELEASE);
	}

	@Override
	protected double determineAmount(int daysRented) {
		return daysRented * 3;
	}

	@Override
	protected int determineFrequentRenterPoints(int rentalDays) {
		return rentalDays > 1 ? 2 : 1;
	}

}
