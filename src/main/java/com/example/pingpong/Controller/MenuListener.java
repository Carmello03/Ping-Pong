package com.example.pingpong.Controller;

import com.example.pingpong.Model.Game;
import com.example.pingpong.View.GameView;
import javafx.application.Platform;
import javafx.scene.control.*;

import java.util.Optional;

public class MenuListener {
    private Game game;
    private SceneToScene toScene;
    public MenuListener(Game game, SceneToScene toScene, GameView gameview)
    {
        this.game = game;
        this.toScene = toScene;
    }

    public void setExit() {
        Platform.exit();
    }

    public void start() {
        toScene.toGame();
    }
    public void setAbout() {
        System.out.println("ABOUT");
        var alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Super Ping pong");
        alert.setHeaderText("Made in Cork");
        alert.setContentText("All rights resereved");
        alert.showAndWait().ifPresent((btnType) -> {
        });
    }
    public void setPlayer1Name(String name) {
        game.getPlayer1().setName(name);
    }

    public void setPlayer2Name(String name) {
        game.getPlayer2().setName(name);
    }

    public void setBallSpeed(int speed) {
        game.getBall().setSpeed(speed);
    }

    public void setRacketSize(int size) {
        int sizeSet = 60;
        switch (size) {
            case 1: // large
                sizeSet = (int) (game.getPlayer1().getRacket().getLength() * 1.7);
                break;
            case 2: // medium
                sizeSet = (int) (game.getPlayer1().getRacket().getLength());
                break;
            case 3: // small
                sizeSet = (int) (game.getPlayer1().getRacket().getLength() * 0.5);
                break;
        }
        game.getPlayer1().getRacket().setLength(sizeSet);
        game.getPlayer2().getRacket().setLength(sizeSet);
    }

    public void setWinningScore(int score) {
        game.setMaxScore(score);
    }

    public void setSpeedIncreaseFrequency(int frequency) {
        game.getBall().setSpeedIncreaseFrequency(frequency);
    }
}