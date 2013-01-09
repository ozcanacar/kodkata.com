package com.kodkata.kata.tennis.done;

import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {

	private TennisGame game = new TennisGame();

	@Test
	public void new_game_should_return_love_all() throws Exception {
		assertEquals("Love all", game.getScore());
	}

	@Test
	public void player_one_wins_first_ball() throws Exception {
		score(1, 0);
		assertEquals("Fifteen, Love", game.getScore());
	}

	@Test
	public void fifteen_all() throws Exception {
		score(1, 1);
		assertEquals("Fifteen all", game.getScore());
	}

	@Test
	public void player_two_wins_first_two_balls() throws Exception {
		score(0, 2);
		assertEquals("Love, Thirty", game.getScore());
	}

	@Test
	public void player_one_wins_first_three_balls() throws Exception {
		score(3, 0);
		assertEquals("Fourty, Love", game.getScore());
	}

	@Test
	public void players_are_deuce() throws Exception {
		score(3, 3);
		assertEquals("Deuce", game.getScore());
	}

	@Test
	public void player_one_wins_game() throws Exception {
		score(4, 0);
		assertEquals("Player One wins", game.getScore());
	}

	@Test
	public void player_two_wins_game() throws Exception {
		score(0, 4);
		assertEquals("Player Two wins", game.getScore());
	}

	@Test
	public void players_are_deuce_4_4() throws Exception {
		score(4, 4);
		assertEquals("Deuce", game.getScore());
	}

	@Test
	public void player_two_advantage() throws Exception {
		score(3, 4);
		assertEquals("Advantage Player Two", game.getScore());
	}

	@Test
	public void player_one_advantage() throws Exception {
		score(4, 3);
		assertEquals("Advantage Player One", game.getScore());
	}

	@Test
	public void player_two_wins_after_advantage() throws Exception {
		score(3, 5);
		assertEquals("Player Two wins", game.getScore());
	}

	@Test
	public void player_one_wins_after_advantage() throws Exception {
		score(7, 5);
		assertEquals("Player One wins", game.getScore());
	}

	private void score(int playerOneScore, int playerTwoScore) {
		for (int i = 0; i < playerOneScore; i++) {
			game.playerOneScores();
		}
		for (int i = 0; i < playerTwoScore; i++) {
			game.playerTwoScores();
		}

	}
}
