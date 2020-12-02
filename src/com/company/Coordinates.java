package com.company;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private double y;
    private double x;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
