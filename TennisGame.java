package com.hfad.tennis;

class TennisGame {
    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    public void playerOneScores() {
        if (!hasWinner()) playerOneScore++;
    }

    public void playerTwoScores() {
        if (!hasWinner()) playerTwoScore++;
    }

    public boolean hasWinner() {
        return playerOneWins() || playerTwoWins();
    }

    public String getDisplayedScore() {
        if (isDeuce()) return "DEUCE";
        if (hasPlayerOneAdvantage()) return "ADVANTAGE PLAYER ONE";
        if (hasPlayerTwoAdvantage()) return "ADVANTAGE PLAYER TWO";
        if (playerOneWins()) return "PLAYER ONE WINS";
        if (playerTwoWins()) return "PLAYER TWO WINS";
        return getPlayerOneDisplayedScore() + " : " + getPlayerTwoDisplayedScore();
    }

    public boolean isDeuce() {
        return playerOneScore >= 3 && (playerOneScore == playerTwoScore);
    }

    public boolean hasPlayerOneAdvantage() {
        return playerOneScore > 3 && (playerOneScore - playerTwoScore == 1);
    }

    public boolean hasPlayerTwoAdvantage() {
        return playerTwoScore > 3 && (playerTwoScore - playerOneScore == 1);
    }

    private boolean playerOneWins() {
        return playerOneScore > 3 && (playerOneScore - playerTwoScore >= 2);
    }

    private boolean playerTwoWins() {
        return playerTwoScore > 3 && (playerTwoScore - playerOneScore >= 2);
    }

    private String getPlayerOneDisplayedScore() {
        return formatScore(playerOneScore);
    }

    private String getPlayerTwoDisplayedScore() {
        return formatScore(playerTwoScore);
    }

    private String formatScore(int score) {
        if (score == 0) return "0";
        if (score == 1) return "15";
        if (score == 2) return "30";
        if (score == 3) return "40";
        throw new IllegalArgumentException("Illegal score: " + score);
    }
}
