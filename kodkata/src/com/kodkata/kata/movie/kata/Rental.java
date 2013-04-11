package com.kodkata.kata.movie.kata;

public class Rental {

	private int daysRented;
	private Movie movie;

	public Rental(final Movie movie, final int daysrented) {
		this.movie = movie;
		this.daysRented = daysrented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public void setDaysRented(final int daysRented) {
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(final Movie movie) {
		this.movie = movie;
	}

	double determineAmount(final RentalStatement rentalStatement) {
		double thisAmount = 0;
		// determine amounts for each line
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (getDaysRented() > 2) {
				thisAmount += (getDaysRented() - 2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			thisAmount += getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (getDaysRented() > 3) {
				thisAmount += (getDaysRented() - 3) * 1.5;
			}
			break;

		}

		return thisAmount;
	}

	int determineRenterPoints() {
		// add frequent renter points
		int frequentRenterPoints = 1;
		// add bonus for a two day new release rental
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
			frequentRenterPoints++;
		}
		return frequentRenterPoints;
	}

}
