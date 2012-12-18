package com.kodkata.kata.tennis.done;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {

	private static final String ADVANTAGE_PLAYER_ONE = "Advantage Player One";
	private static final String ADVANTAGE_PLAYER_TWO = "Advantage Player Two";
	private static final String PLAYER_TWO_WINS = "Player Two wins";
	private static final String PLAYER_ONE_WINS = "Player One wins";
	private static final String DEUCE = "Deuce";
	private static Map<Integer, String> SCORE_NAMES = new HashMap<Integer, String>() {
		{
			put(0, "Love");
			put(1, "Fifteen");
			put(2, "Thirty");
			put(3, "Fourty");
		}
	};
	private int playerOneScore;
	private int playerTwoScore;

	public String getScore() {
		if (playerOneIsWinner())
			return PLAYER_ONE_WINS;
		if (playerTwoIsWinner())
			return PLAYER_TWO_WINS;
		if (playerOneHasAdvantage())
			return ADVANTAGE_PLAYER_ONE;
		if (playerTwoHasAdvantage())
			return ADVANTAGE_PLAYER_TWO;
		if (isDeuce())
			return DEUCE;
		return getScoreAsString();
	}

	private boolean playerOneHasAdvantage() {
		return playerOneScore == playerTwoScore + 1 && playerOneScore > 3;
	}

	private boolean playerTwoHasAdvantage() {
		return playerTwoScore == playerOneScore + 1 && playerTwoScore > 3;
	}

	private String getScoreAsString() {
		if (scoresEquals())
			return getScoreName(playerOneScore) + " all";
		return getScoreName(playerOneScore) + ", "
				+ getScoreName(playerTwoScore);
	}

	private boolean playerTwoIsWinner() {
		return playerTwoScore > 3 && playerTwoScore > playerOneScore + 1;
	}

	private boolean playerOneIsWinner() {
		return playerOneScore > 3 && playerOneScore > playerTwoScore + 1;
	}

	private boolean isDeuce() {
		return scoresEquals() && playerOneScore > 2;
	}

	private boolean scoresEquals() {
		return playerOneScore == playerTwoScore;
	}

	private String getScoreName(int score) {
		return SCORE_NAMES.get(score);
	}

	public void playerOneScores() {
		playerOneScore++;
	}

	public void playerTwoScores() {
		playerTwoScore++;
	}

}
