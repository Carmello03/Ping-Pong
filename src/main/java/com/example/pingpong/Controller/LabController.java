package com.example.pingpong.Controller;

import com.example.pingpong.Model.Game;

public class LabController {
    private Game game;
    public LabController() {
        Game game = new Game();
    }

    public Game getGame() {
        return game;
    }

}