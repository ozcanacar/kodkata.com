package com.kodkata.kata.movie.kata;


public class RegularMovie extends Movie {

	public RegularMovie(String title) {
		super(title, REGULAR);
	}

	@Override
	protected double determineAmount(int daysRented) {
		double rentalAmount = 2;
		if (daysRented > 2)
			rentalAmount += (daysRented - 2) * 1.5;
		return rentalAmount;
	}

	@Override
	protected int determineFrequentRenterPoints(int rentalDays) {
		return 1;
	}

}
