package com.kodkata.kata.replaceConditionalDispatcherWithCommand.orig;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class OrderAssert extends AbstractAssert<OrderAssert, Order> {

    private String locale;
    private int price;

    private OrderAssert(final Order actual) {
        super(actual, OrderAssert.class);
    }

    public static OrderAssert assertThat(final Order actual) {
        return new OrderAssert(actual);
    }

    public OrderAssert hasTotalPrice(final int total) {
        isNotNull();

        Assertions.assertThat(actual.calculatePrice(locale, price)).isEqualTo(total);
        return this;
    }

    public OrderAssert inCountry(final String locale) {
        this.locale = locale;
        return this;
    }

    public OrderAssert withPrice(final int price) {
        this.price = price;
        return this;
    }
}
