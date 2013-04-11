package com.kodkata.kata.movie.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RentalStatement {

	private List<Rental> rentals = new ArrayList<Rental>();
	private String name;
	double totalAmount;
	private int frequentRenterPoints;

	public RentalStatement(final String _name) {
		this.name = _name;
	}

	public String statement() {
		clearTotals();
		return makeHeader() + rentalLines() + makeFooter();
	}

	private String rentalLines() {
		String rentalLines = "";
		for (final Rental rental : rentals) {
			rentalLines += rentalLine(rental);
		}
		return rentalLines;
	}

	private String rentalLine(final Rental rental) {
		final double thisAmount = rental.determineAmount(this);
		totalAmount += thisAmount;
		frequentRenterPoints += rental.determineRenterPoints();
		return formatRentalLine(rental, thisAmount);
	}

	private String formatRentalLine(final Rental rental, final double thisAmount) {
		return "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
	}

	private String makeFooter() {
		return "Amount owed is " + String.valueOf(totalAmount) + "\n" + "You earned "
				+ String.valueOf(frequentRenterPoints) + " frequent renter points";
	}

	private String makeHeader() {
		final String result = "Rental Record for " + getName() + "\n";
		return result;
	}

	private void clearTotals() {
		totalAmount = 0;
		frequentRenterPoints = 0;
	}

	public void addRental(final Rental arg) {
		rentals.add(arg);
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(final Vector rentals) {
		this.rentals = rentals;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public double getAmount() {
		return this.totalAmount;
	}

	public Integer getFrequentRenterPoints() {
		return this.frequentRenterPoints;
	}

}
