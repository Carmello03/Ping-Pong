package com.example.pingpong.Model;

public class Player {
    private String name;
    private int score;
    private Racket racket;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.racket = new Racket();
    }

    public Player(String name, Racket racket) {
        this.name = name;
        this.racket = racket;
    }

    public void scorePoint() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Racket getRacket() {
        return racket;
    }

    public void setRacket(Racket racket) {
        this.racket = racket;
    }

}