package com.kodkata.kata.replaceConditionalDispatcherWithCommand.orig;

import static com.kodkata.kata.replaceConditionalDispatcherWithCommand.orig.OrderAssert.assertThat;

import org.junit.Test;

public class PriceCalculatorTest {

    private static final String LOCALE_TURKISH_REPUBLIC = "tr_TR";
    private static final int DEFAULT_NETTO_PRICE = 100;
    private static final String LOCALE_GERMANY = "de_DE";
    private static final String LOCALE_AUSTRIA = "at_AT";
    private final Order order = new Order();

    @Test
    public void shouldCalculatePriceForGermanLocale() throws Exception {

        assertThat(order).inCountry(LOCALE_GERMANY).withPrice(DEFAULT_NETTO_PRICE).hasTotalPrice(119);
    }

    @Test
    public void shouldCalculatePriceForTurkishLocale() throws Exception {

        assertThat(order).inCountry(LOCALE_TURKISH_REPUBLIC).withPrice(DEFAULT_NETTO_PRICE).hasTotalPrice(118);
    }

    @Test
    public void shouldCalculatePriceForAustrianLocale() throws Exception {

        assertThat(new Order()).inCountry(LOCALE_AUSTRIA).withPrice(DEFAULT_NETTO_PRICE).hasTotalPrice(120);
    }

}
