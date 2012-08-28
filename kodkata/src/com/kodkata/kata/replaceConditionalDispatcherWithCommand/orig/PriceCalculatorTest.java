package com.kodkata.kata.replaceConditionalDispatcherWithCommand.orig;

import junit.framework.Assert;

import org.junit.Test;

public class PriceCalculatorTest
{

	private static final String	LOCALE_TURKISH_REPUBLIC	= "tr_TR";
	private static final int	DEFAULT_NETTO_PRICE		= 100;
	private static final String	LOCALE_GERMANY			= "de_DE";
	private static final String	LOCALE_AUSTRIA			= "at_AT";

	@Test
	public void shouldCalculatePriceForGermanLocale() throws Exception
	{

		Assert.assertTrue(new Order().calculatePrice(LOCALE_GERMANY, DEFAULT_NETTO_PRICE) == 119);
	}

	@Test
	public void shouldCalculatePriceForTurkishLocale() throws Exception
	{

		Assert.assertTrue(new Order().calculatePrice(LOCALE_TURKISH_REPUBLIC, DEFAULT_NETTO_PRICE) == 118);
	}

	@Test
	public void shouldCalculatePriceForAustrianLocale() throws Exception
	{

		Assert.assertTrue(new Order().calculatePrice(LOCALE_AUSTRIA, DEFAULT_NETTO_PRICE) == 120);
	}

}
