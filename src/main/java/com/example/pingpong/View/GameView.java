package com.example.pingpong.View;

import com.example.pingpong.Model.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameView extends Canvas {
    private Game game;
    private double racketOffset = 10;

    public GameView(double width, double height) {
        super(width, height);
        // Add listeners to redraw the game whenever the window is resized
        widthProperty().addListener(observable -> drawGame());
        heightProperty().addListener(observable -> drawGame());
    }

    public void setGame(Game game) {
        this.game = game;
        drawGame(); // Initial draw
    }

    public void drawGame() {
        if (game == null) return; // Don't draw if the game is not set

        GraphicsContext gc = this.getGraphicsContext2D();
        drawBackground(gc);
        drawBall(gc, game.getBall());
        drawRacket(gc, game.getPlayer1().getRacket(), racketOffset); // Player 1 on left
        drawRacket(gc, game.getPlayer2().getRacket(), getWidth() - game.getPlayer2().getRacket().getWidth() - racketOffset); // Player 2 on right
        drawScore(gc, game.getPlayer1(), game.getPlayer2());
    }

    private void drawRacket(GraphicsContext gc, Racket racket, double xPosition) {
        double yPosition = getHeight() / 2 - racket.getLength() / 2.0;
        gc.setFill(Color.WHITE); // Set to the racket's color
        gc.fillRect(xPosition, yPosition, racket.getWidth(), racket.getLength());
    }

    private void drawBackground(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        gc.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void drawBall(GraphicsContext gc, Ball ball) {
        double radius = ball.getRadius();
        double centerX = getWidth() / 2 - radius;
        double centerY = getHeight() / 2 - radius;
        gc.setFill(Color.YELLOWGREEN);
        gc.fillOval(centerX, centerY, radius * 2, radius * 2);
    }

    public void drawScore(GraphicsContext gc, Player player1, Player player2) {
        gc.setFill(Color.WHITE);

        // Define the score and player name display format
        String player1Score = String.valueOf(player1.getScore());
        String player2Score = String.valueOf(player2.getScore());
        String player1Name = player1.getName(); // Assuming getName() method exists
        String player2Name = player2.getName(); // Assuming getName() method exists

        // Calculate positions based on the canvas width
        double midX = getWidth() / 2;
        double scorePosY = 50;
        double namePosY = scorePosY + 30; // Adjust as needed

        // Draw player 1's name and score on the left
        gc.fillText(player1Name, midX - 100, namePosY); // Adjust position as needed
        gc.fillText(player1Score, midX - 50, scorePosY);

        // Draw player 2's name and score on the right
        gc.fillText(player2Name, midX + 50, namePosY); // Adjust position as needed
        gc.fillText(player2Score, midX + 10, scorePosY);
    }
}