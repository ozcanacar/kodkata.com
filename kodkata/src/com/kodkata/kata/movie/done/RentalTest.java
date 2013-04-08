package com.kodkata.kata.movie.done;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Locale;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class RentalTest {

	private RentalStatement statement;
	private Movie newReleaseMovie1 = new NewReleaseMovie("Rambo");
	private Movie newReleaseMovie2 = new NewReleaseMovie("Rambo2");
	private Movie childrensMovie = new ChildrenMovie("Winipoo");
	private Movie regularMovie1 = new RegularMovie("Winipoa");
	private Movie regularMovie2 = new RegularMovie("Winipoa2");

	@Before
	public void setup() {

		statement = new RentalStatement("Acar");
		Locale.setDefault(new Locale("en_EN"));
	}

	private void assert_that_total_amount_and_frequent_renter_points_correct(
			double amount, int bonus) {
		statement.makeStatement();
		assertThat(statement.getTotal(), is(equalTo(amount)));
		assertThat(statement.getFrequentRenterPoints(), is(equalTo(bonus)));
	}

	@Test
	public void whenRentedANewRelase_AmountShouldBe_9_0() throws Exception {
		statement.addRental(new Rental(newReleaseMovie1, 3));
		assert_that_total_amount_and_frequent_renter_points_correct(9.0, 2);
	}

	@Test
	public void whenRentedANewRelase_AmountShouldBe_3_0() throws Exception {
		statement.addRental(new Rental(newReleaseMovie1, 1));
		assert_that_total_amount_and_frequent_renter_points_correct(3.0, 1);
	}

	@Test
	public void whenRentedTwoNewRelase_AmountShouldBe_18_0() throws Exception {
		statement.addRental(new Rental(newReleaseMovie1, 3));
		statement.addRental(new Rental(newReleaseMovie2, 3));
		assert_that_total_amount_and_frequent_renter_points_correct(18, 4);
	}

	@Test
	public void whenRentedAChildrenMovie_AmountShouldBe_1_5() throws Exception {
		statement.addRental(new Rental(childrensMovie, 2));
		assert_that_total_amount_and_frequent_renter_points_correct(1.5, 1);
	}

	@Test
	public void whenRentedAChildrenMovieForFourDays_AmountShouldBe_1_5()
			throws Exception {
		statement.addRental(new Rental(childrensMovie, 4));
		assert_that_total_amount_and_frequent_renter_points_correct(3.0, 1);
	}

	@Test
	public void whenRentedARegular_AmountShouldBe_2_0() throws Exception {
		statement.addRental(new Rental(regularMovie1, 1));
		assert_that_total_amount_and_frequent_renter_points_correct(2.0, 1);
	}

	@Test
	public void whenRentedARegularMovieForSixDays_AmountShouldBe_8_0()
			throws Exception {
		statement.addRental(new Rental(regularMovie1, 6));
		Assert.assertEquals("" + "Rental Record for Acar\n"
				+ "\tWinipoa\t8.0\n" + "Amount owed is 8.0\n"
				+ "You earned 1 frequent renter points", statement.makeStatement());
	}

	@Test
	public void whenRentedTwoRegularMoviesForSixDays_AmountShouldBe_16_0()
			throws Exception {
		statement.addRental(new Rental(regularMovie1, 6));
		statement.addRental(new Rental(regularMovie2, 6));
		Assert.assertEquals("" + "Rental Record for Acar\n"
				+ "\tWinipoa\t8.0\n" + "\tWinipoa2\t8.0\n"
				+ "Amount owed is 16.0\n"
				+ "You earned 2 frequent renter points", statement.makeStatement());
	}

}
