package com.kodkata.kata.movie.orig;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private Vector rentals = new Vector();
    private String name;

    public Customer(String _name) {

	this.name = _name;
    }

    public String statement() {
	double totalAmount = 0;
	int frequentRenterPoints = 0;
	Enumeration rentals = getRentals().elements();
	String result = "Rental Record for " + getName() + "\n";
	while (rentals.hasMoreElements()) {
	    double thisAmount = 0;
	    Rental each = (Rental) rentals.nextElement();

	    // determine amounts for each line
	    switch (each.getMovie().getPriceCode()) {
	    case Movie.REGULAR:
		thisAmount += 2;
		if (each.getDaysRented() > 2)
		    thisAmount += (each.getDaysRented() - 2) * 1.5;
		break;
	    case Movie.NEW_RELEASE:
		thisAmount += each.getDaysRented() * 3;
		break;
	    case Movie.CHILDRENS:
		thisAmount += 1.5;
		if (each.getDaysRented() > 3)
		    thisAmount += (each.getDaysRented() - 3) * 1.5;
		break;

	    }
	    totalAmount += thisAmount;

	    // add frequent renter points
	    frequentRenterPoints++;
	    // add bonus for a two day new release rental
	    if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
		    && each.getDaysRented() > 1)
		frequentRenterPoints++;

	    // show figures for this rental
	    result += "\t" + each.getMovie().getTitle() + "\t"
		    + String.valueOf(thisAmount) + "\n";

	}
	// add footer lines
	result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
	result += "You earned " + String.valueOf(frequentRenterPoints)
		+ " frequent renter points";
	return result;

    }

    public void addRental(Rental arg) {
	rentals.addElement(arg);
    }

    public Vector getRentals() {
	return rentals;
    }

    public void setRentals(Vector rentals) {
	this.rentals = rentals;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
