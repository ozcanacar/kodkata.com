package com.kodkata.kata.replaceConditionalDispatcherWithCommand.kata;

public class AbstractPriceCalculator {

	public AbstractPriceCalculator() {
		super();
	}

	protected Double calculatePrice(final double price, double taxRate) {
		final Double tax = Double.valueOf((price / 100) * taxRate);
		return Double.valueOf(tax.doubleValue() + price);
	}

}