package com.kodkata.kata.movie.done;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RentalStatement {

	private List<Rental> rentals = new ArrayList<Rental>();
	private String customerName;
	private double totalAmount;
	private int frequentRenterPoints;

	public RentalStatement(String customername) {
		this.customerName = customername;
	}

	public String makeStatement() {
		clearTotals();
		return makeHeader() + rentalLines() + makeFooter();
	}

	private String makeHeader() {
		String result = "Rental Record for " + getCustomerName() + "\n";
		return result;
	}

	private String rentalLines() {
		String rentalLines = "";
		for (Rental rental : rentals) {
			rentalLines += rentalLine(rental);
		}
		return rentalLines;
	}

	private String rentalLine(Rental each) {
		double thisAmount = each.determineAmount();
		this.totalAmount += thisAmount;
		this.frequentRenterPoints += each.determineFrequentRenterPoints();
		return formatRentalLine(each, thisAmount);
	}

	private String formatRentalLine(Rental rental, double thisAmount) {
		return "\t" + rental.getTitle() + "\t"
				+ String.valueOf(thisAmount) + "\n";
	}

	private String makeFooter() {
		return "Amount owed is " + String.valueOf(totalAmount) + "\n"
				+ "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
	}

	private void clearTotals() {
		totalAmount = 0;
		frequentRenterPoints = 0;
	}

	public void addRental(Rental arg) {
		rentals.add(arg);
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(Vector rentals) {
		this.rentals = rentals;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String name) {
		this.customerName = name;
	}

	public int getFrequentRenterPoints() {
		return this.frequentRenterPoints;
	}

	public double getTotal() {
		return this.totalAmount;
	}

}
