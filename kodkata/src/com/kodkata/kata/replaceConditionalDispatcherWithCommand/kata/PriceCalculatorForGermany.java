package com.kodkata.kata.replaceConditionalDispatcherWithCommand.kata;

public class PriceCalculatorForGermany extends AbstractPriceCalculator implements PriceCalculator {
	
	private static final double TAX_RATE = 19.00;

	@Override
	public Double calculate(final double price) {
		return calculatePrice(price, TAX_RATE);
	}
}
