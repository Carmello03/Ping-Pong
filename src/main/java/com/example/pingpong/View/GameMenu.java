package com.example.pingpong.View;

import com.example.pingpong.Controller.MenuListener;
import com.example.pingpong.Controller.SceneToScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameMenu {
    private MenuListener menuListener;
    private VBox menuMain;
    private Button start, menuItemExit, menuItemAbout;

    private HBox racketSizeOptions;
    private ToggleGroup racketSizeGroup;
    private TextField setPlayer1Name, setPlayer2Name;
    private Slider setBallSpeed, setWinningScore, setSpeedIncreaseFrequency;

    public GameMenu(MenuListener menuListener) {
        this.menuListener = menuListener;

        // Initialize menu items
        initializeMenu();

        start = new Button("START");

        // Add menu items to menu
        menuMain();

        // Handle menu item actions
        handleMenuAction();
    }

    public void initializeMenu() {
        setPlayer1Name = new TextField();
        setPlayer2Name = new TextField();
        setBallSpeed = new Slider(1, 10, 5);

        // Radio buttons for racket size
        racketSizeGroup = new ToggleGroup();

        // Create the radio buttons
        RadioButton smallRacket = new RadioButton("Small");
        smallRacket.setUserData(3); // The value 10 represents a small racket size
        smallRacket.setToggleGroup(racketSizeGroup);

        RadioButton mediumRacket = new RadioButton("Medium");
        mediumRacket.setUserData(2); // The value 30 represents a medium racket size
        mediumRacket.setToggleGroup(racketSizeGroup);
        mediumRacket.setSelected(true); // Set as default selection

        RadioButton largeRacket = new RadioButton("Large");
        largeRacket.setUserData(1); // The value 50 represents a large racket size
        largeRacket.setToggleGroup(racketSizeGroup);

        // Add the radio buttons to the HBox
        racketSizeOptions = new HBox(10); // 10 is the spacing between elements
        racketSizeOptions.getChildren().addAll(smallRacket, mediumRacket, largeRacket);
        racketSizeOptions.setAlignment(Pos.CENTER); // Center the buttons in the HBox

        // Set the default selected radio button if necessary
        mediumRacket.setSelected(true);

        setWinningScore = new Slider(1, 21, 11);
        setSpeedIncreaseFrequency = new Slider(1, 10, 2);

        // Buttons for about and exit
        menuItemAbout = new Button("About");
        menuItemExit = new Button("Exit");

    }

    public void handleMenuAction() {
        setPlayer1Name.setOnAction(e -> menuListener.setPlayer1Name(setPlayer1Name.getText()));
        setPlayer2Name.setOnAction(e -> menuListener.setPlayer2Name(setPlayer2Name.getText()));
        setBallSpeed.valueProperty().addListener((obs, oldVal, newVal) ->
                menuListener.setBallSpeed(newVal.intValue()));
        racketSizeGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                int racketSize = (int) newValue.getUserData();
                menuListener.setRacketSize(racketSize);
            }
        });
        setWinningScore.valueProperty().addListener((obs, oldVal, newVal) ->
                menuListener.setWinningScore(newVal.intValue()));
        setSpeedIncreaseFrequency.valueProperty().addListener((obs, oldVal, newVal) ->
                menuListener.setSpeedIncreaseFrequency(newVal.intValue()));
        menuItemExit.setOnAction(e -> menuListener.setExit());
        menuItemAbout.setOnAction(e -> menuListener.setAbout());
        start.setOnAction(e -> menuListener.start());
    }

    public void menuMain() {
        Label title = new Label("Ping-Pong");
        title.getStyleClass().add("title-label");

        // Container for player name inputs
        HBox playerNames = new HBox(menuMainPlayers("Player 1: ", setPlayer1Name),
                menuMainPlayers("Player 2: ", setPlayer2Name));
        playerNames.getStyleClass().add("form-container");

        // Container for settings sliders and the new radio buttons for racket size
        VBox settings = new VBox(
                menuMainSettings("Set Ball Speed", setBallSpeed),
                menuMainSettings("Set Racket Size", racketSizeOptions), // Use the HBox for radio buttons here
                menuMainSettings("Set Winning Score", setWinningScore),
                menuMainSettings("Set Speed Increase Frequency", setSpeedIncreaseFrequency)
        );
        settings.getStyleClass().add("form-container");

        // Container for the new about and exit buttons
        HBox aboutExitButtons = new HBox(10, menuItemAbout, menuItemExit);
        aboutExitButtons.getStyleClass().add("form-container");

        // Container for all form elements
        VBox form = new VBox(playerNames, settings, aboutExitButtons, start);
        form.getStyleClass().add("form-container");

        this.menuMain = new VBox(5); // Adjust spacing as needed
        this.menuMain.setAlignment(Pos.TOP_CENTER); // Align to the top and center children
        this.menuMain.getChildren().addAll(title, playerNames, settings, aboutExitButtons, start);
        this.menuMain.getStyleClass().add("root"); // Ensure this class is applied for background styling
    }

    public HBox menuMainSettings(String settingsLabel, javafx.scene.Node settingAction) {
        Label setting = new Label(settingsLabel);
        setting.getStyleClass().add("label"); // Apply the label style class

        HBox settingsBox = new HBox(10, setting, settingAction);
        settingsBox.setAlignment(Pos.CENTER);
        settingsBox.getStyleClass().add("settings-box"); // You can define this in your CSS for further customization
        return settingsBox;
    }

    public HBox menuMainPlayers(String label, TextField textField) {
        Label player = new Label(label);
        HBox playersBox = new HBox(10, player, textField);
        playersBox.setAlignment(Pos.CENTER);
        return playersBox;
    }

    // Getter for menuBar
    public VBox getMenuMain() {
        return menuMain;
    }

    public TextField getSetPlayerName1() {
        return setPlayer1Name;
    }

    public TextField getSetPlayerName2() {
        return setPlayer2Name;
    }
}
