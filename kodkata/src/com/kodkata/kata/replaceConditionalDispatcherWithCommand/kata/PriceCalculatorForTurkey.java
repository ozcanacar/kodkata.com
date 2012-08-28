package com.kodkata.kata.replaceConditionalDispatcherWithCommand.kata;

public class PriceCalculatorForTurkey extends AbstractPriceCalculator implements
		PriceCalculator {

	private static final double TAX_RATE = 18.00;
	
	@Override
	public Double calculate(final double price) {
		return calculatePrice(price, TAX_RATE);
	}

}
