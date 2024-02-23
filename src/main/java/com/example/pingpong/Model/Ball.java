package com.example.pingpong.Model;

public class Ball implements Resizable {
    private int speed;
    private int speedIncreaseFrequency;
    private double radius;

    private double posX;
    private double posY;

    public Ball() {
        this.speed = 1;
        this.speedIncreaseFrequency = 1;
        this.radius = 15;
    }

    public Ball(int speed, int speedIncreaseFrequency, double radius) {
        this.speed = speed;
        this.speedIncreaseFrequency = speedIncreaseFrequency;
        this.radius = radius;
    }

    // Getter and setter methods for speed, speedIncreaseFrequency, and radius
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeedIncreaseFrequency() {
        return speedIncreaseFrequency;
    }

    public void setSpeedIncreaseFrequency(int speedIncreaseFrequency) {
        this.speedIncreaseFrequency = speedIncreaseFrequency;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    // Getter and setter methods for posX and posY
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
        this.posX *= factor;
    }

    @Override
    public void resizeY(double factor) {
        this.posY *= factor;
    }
}