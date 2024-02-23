package com.example.pingpong.Model;

public class Game implements Resizable {
    // Game settings
    private Player player1;
    private Player player2;
    private Ball ball;

    private int maxScore;

    public Game() {
        this.player1 = new Player("Player 1");
        this.player2 = new Player("Player 2");
        this.ball = new Ball();
        this.maxScore = 5;
    }

//    public Game(String player1, String player2, int racketWidth, int racketLength,
//                int speed, int speedIncreaseFrequency, double radius, int maxScore) {
//        this.player1 = new Player(player1, new Racket(racketWidth, racketLength));
//        this.player2 = new Player(player2, new Racket(racketWidth, racketLength));
//        this.ball = new Ball(speed, speedIncreaseFrequency, radius);
//        this.maxScore = maxScore;
//    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player) {
        this.player1 = player;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player) {
        this.player2 = player;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    @Override
    public void resizeX(double factor) {
        // Resize logic for the game along the X-axis
        // You may need to update the positions and dimensions of players and the ball
        player1.getRacket().resizeX(factor);
        player2.getRacket().resizeX(factor);
        ball.resizeX(factor);
        // Adjust any other attributes that need to be resized along the X-axis
    }

    @Override
    public void resizeY(double factor) {
        // Resize logic for the game along the Y-axis
        // You may need to update the positions and dimensions of players and the ball
        player1.getRacket().resizeY(factor);
        player2.getRacket().resizeY(factor);
        ball.resizeY(factor);
        // Adjust any other attributes that need to be resized along the Y-axis
    }
}