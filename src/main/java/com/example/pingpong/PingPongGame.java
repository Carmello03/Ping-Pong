package com.example.pingpong;

import com.example.pingpong.Controller.MenuListener;
import com.example.pingpong.Controller.SceneToScene;
import com.example.pingpong.Model.Game;
import com.example.pingpong.View.GameMenu;
import com.example.pingpong.View.GameView;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Objects;

public class PingPongGame extends Application implements SceneToScene {
    private Game game;
    private MenuListener menuListener;
    private GameMenu gameMenu;
    private GameView canvas;
    private final String title = "Ping Pong";

    @Override
    public void init() {
        canvas = new GameView(600, 400);
        game = new Game();

        menuListener = new MenuListener(game, this, canvas);
        gameMenu = new GameMenu(menuListener);
        canvas.setGame(game);
    }

    @Override
    public void start(Stage primaryStage) {
        // Existing setup code
        VBox root = gameMenu.getMenuMain();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 1100, 650);

        // Link the stylesheet
        String css = this.getClass().getResource("/com/example/pingpong/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        // More setup code
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @Override
    public void toMenu() {
        VBox root = gameMenu.getMenuMain();
        Scene menuMainScene = new Scene(root, 600, 600);
        Stage primaryStage = (Stage) canvas.getScene().getWindow();
        primaryStage.setScene(menuMainScene);
    }
    @Override
    public void toGame() {
        AnchorPane gameAnchorPane = new AnchorPane();
        GameView gameView = new GameView(600, 400);
        gameView.setGame(game);

        // Set the GameView (Canvas) to stretch to the size of the AnchorPane
        AnchorPane.setTopAnchor(gameView, 0.0);
        AnchorPane.setBottomAnchor(gameView, 0.0);
        AnchorPane.setLeftAnchor(gameView, 0.0);
        AnchorPane.setRightAnchor(gameView, 0.0);

        gameAnchorPane.getChildren().add(gameView);
        Scene gameScene = new Scene(gameAnchorPane, 1100, 650);
        Stage primaryStage = (Stage) gameMenu.getMenuMain().getScene().getWindow();
        primaryStage.setScene(gameScene);

        // Bind the canvas size to the scene size
        gameView.widthProperty().bind(gameScene.widthProperty());
        gameView.heightProperty().bind(gameScene.heightProperty());

        // Update the canvas when the scene size changes
        gameScene.widthProperty().addListener((observable, oldValue, newValue) -> {
            double factor = newValue.doubleValue() / oldValue.doubleValue();
            game.resizeX(factor);
            gameView.drawGame();
        });

        gameScene.heightProperty().addListener((observable, oldValue, newValue) -> {
            double factor = newValue.doubleValue() / oldValue.doubleValue();
            game.resizeY(factor);
            gameView.drawGame();
        });
    }


    public static void main(String[] args) {
        launch(args);
    }

    public GameMenu getGameMenu() {
        return gameMenu;
    }

    public void setGameMenu(GameMenu gameMenu) {
        this.gameMenu = gameMenu;
    }

    public GameView getCanvas() {
        return canvas;
    }

    public void setCanvas(GameView canvas) {
        this.canvas = canvas;
    }

}