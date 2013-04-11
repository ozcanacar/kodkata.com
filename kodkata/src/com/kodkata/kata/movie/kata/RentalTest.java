package com.kodkata.kata.movie.kata;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Locale;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class RentalTest {

	private RentalStatement customer;
	private final Movie newReleaseMovie1 = new Movie("Rambo", Movie.NEW_RELEASE);
	private final Movie newReleaseMovie2 = new Movie("Rambo2", Movie.NEW_RELEASE);
	private final Movie childrensMovie = new Movie("Winipoo", Movie.CHILDRENS);
	private final Movie regularMovie1 = new Movie("Winipoa", Movie.REGULAR);
	private final Movie regularMovie2 = new Movie("Winipoa2", Movie.REGULAR);

	@Before
	public void setup() {
		customer = new RentalStatement("Acar");
		Locale.setDefault(new Locale("en_EN"));
	}

	@Test
	public void whenRentedANewRelase_AmountShouldBe_9_0() throws Exception {
		customer.addRental(new Rental(newReleaseMovie1, 3));
		customer.statement();
		assertThat(customer.getAmount(), is(equalTo(9.0)));
		assertThat(customer.getFrequentRenterPoints(), is(equalTo(2)));
	}

	@Test
	public void whenRentedANewRelase_AmountShouldBe_3_0() throws Exception {
		customer.addRental(new Rental(newReleaseMovie1, 1));
		Assert.assertEquals("" + "Rental Record for Acar\n" + "\tRambo\t3.0\n" + "Amount owed is 3.0\n"
				+ "You earned 1 frequent renter points", customer.statement());
	}

	@Test
	public void whenRentedTwoNewRelase_AmountShouldBe_18_0() throws Exception {
		customer.addRental(new Rental(newReleaseMovie1, 3));
		customer.addRental(new Rental(newReleaseMovie2, 3));
		Assert.assertEquals("" + "Rental Record for Acar\n" + "\tRambo\t9.0\n\tRambo2\t9.0\n" + "Amount owed is 18.0\n"
				+ "You earned 4 frequent renter points", customer.statement());
	}

	@Test
	public void whenRentedAChildrenMovie_AmountShouldBe_1_5() throws Exception {
		customer.addRental(new Rental(childrensMovie, 2));
		Assert.assertEquals("" + "Rental Record for Acar\n" + "\tWinipoo\t1.5\n" + "Amount owed is 1.5\n"
				+ "You earned 1 frequent renter points", customer.statement());
	}

	@Test
	public void whenRentedAChildrenMovieForFourDays_AmountShouldBe_1_5() throws Exception {
		customer.addRental(new Rental(childrensMovie, 4));
		Assert.assertEquals("" + "Rental Record for Acar\n" + "\tWinipoo\t3.0\n" + "Amount owed is 3.0\n"
				+ "You earned 1 frequent renter points", customer.statement());
	}

	@Test
	public void whenRentedARegular_AmountShouldBe_2_0() throws Exception {
		customer.addRental(new Rental(regularMovie1, 1));
		Assert.assertEquals("" + "Rental Record for Acar\n" + "\tWinipoa\t2.0\n" + "Amount owed is 2.0\n"
				+ "You earned 1 frequent renter points", customer.statement());
	}

	@Test
	public void whenRentedARegularMovieForSixDays_AmountShouldBe_8_0() throws Exception {
		customer.addRental(new Rental(regularMovie1, 6));
		Assert.assertEquals("" + "Rental Record for Acar\n" + "\tWinipoa\t8.0\n" + "Amount owed is 8.0\n"
				+ "You earned 1 frequent renter points", customer.statement());
	}

	@Test
	public void whenRentedTwoRegularMoviesForSixDays_AmountShouldBe_16_0() throws Exception {
		customer.addRental(new Rental(regularMovie1, 6));
		customer.addRental(new Rental(regularMovie2, 6));
		Assert.assertEquals("" + "Rental Record for Acar\n" + "\tWinipoa\t8.0\n" + "\tWinipoa2\t8.0\n"
				+ "Amount owed is 16.0\n" + "You earned 2 frequent renter points", customer.statement());
	}

}
