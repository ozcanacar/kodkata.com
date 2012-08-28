package com.kodkata.kata.movie.kata;


public class ChildrenMovie extends Movie {

	public ChildrenMovie(String title) {
		super(title, CHILDRENS);
	}

	@Override
	protected double determineAmount(int daysRented) {
		double rentalAmount = 1.5;
		if (daysRented > 3)
			rentalAmount += (daysRented - 3) * 1.5;
		return rentalAmount;
	}

	@Override
	protected int determineFrequentRenterPoints(int rentalDays) {
		return 1;
	}

}
