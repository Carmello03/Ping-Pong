package com.example.pingpong.Model;

public class Racket implements Resizable {
    private int width;
    private int length;
    private double posX; // Position of the racket along the X-axis
    private double posY; // Position of the racket along the Y-axis

    public Racket() {
        this.width = 10;
        this.length = 60;
        this.posX = 0; // Initialize posX to 0
        this.posY = 0; // Initialize posY to 0
    }

    public Racket(int width, int length, double posX, double posY) {
        this.width = width;
        this.length = length;
        this.posX = posX;
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    @Override
    public void resizeX(double factor) {
        // Adjust posX based on the resizing factor
        this.posX *= factor;
    }

    @Override
    public void resizeY(double factor) {
        // Adjust posY based on the resizing factor
        this.posY *= factor;
    }
}