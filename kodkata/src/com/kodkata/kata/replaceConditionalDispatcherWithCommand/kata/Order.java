package com.kodkata.kata.replaceConditionalDispatcherWithCommand.kata;

import java.util.HashMap;

public class Order {

	HashMap<String, PriceCalculator> handler = new HashMap<String, PriceCalculator>()
	{{
		put("de_DE", new PriceCalculatorForGermany());
		put("at_AT", new PriceCalculatorForAustria());
		put("tr_TR", new PriceCalculatorForTurkey());
		
	}};
	
	public Double calculatePrice(final String locale, final double price) {
		return getHandler(locale).calculate(price);
	}

	private PriceCalculator getHandler(String locale) {
		return toHandler(locale);
	}

	private PriceCalculator toHandler(String locale) {
		return handler.get(locale);
	}
	
}