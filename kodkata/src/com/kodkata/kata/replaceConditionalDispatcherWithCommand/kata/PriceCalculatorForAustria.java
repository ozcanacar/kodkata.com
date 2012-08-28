package com.kodkata.kata.replaceConditionalDispatcherWithCommand.kata;

public class PriceCalculatorForAustria extends AbstractPriceCalculator implements
		PriceCalculator {

	private static final double TAX_RATE =20.00;
	
	@Override
	public Double calculate(final double price) {
		return calculatePrice(price, TAX_RATE);
	}
}
