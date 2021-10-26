package MiddletonLibrary.Math;

import androidx.annotation.NonNull;

import static java.lang.Math.*;
import static java.util.Locale.US;

/**
 * Created by Keval Kataria on 3/15/2021
 */

public class Vector {
    private double x;
    private double y;
    private String name;

    public Vector(String name, double x, double y) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public double getX() {return x;}
    public double getY() {return y;}
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}

    public double getMagnitude () {return hypot(getX(), getY());}
    public double getDirection () {return toDegrees(atan(getY() / getX()));}
    public Vector unitVector () {return new Vector(name, getX()/getMagnitude(), getY()/getMagnitude());}

    public Vector multiply(double scalar) {return new Vector(name, getX() * scalar, getY() * scalar);}
    public Vector displacement(Vector v) {return new Vector(name, v.getX() - getX(), v.getY() - getY());}
    public Vector projectOnTo(Vector v) {return v.unitVector().multiply(dotProduct(v.unitVector()));}
    public Vector add(Vector v) {return new Vector(name, getX() + v.getX(), getY() + v.getY());}
    public double dotProduct(Vector v) {return (this.getX() * v.getX()) + (this.getY() * v.getY());}
    public double angleTo(Vector v) {return toDegrees(atan2(getY(), getX()) - atan2(v.getY(), v.getX()));}
    public double distanceToVector(Vector v) {return hypot(v.getX() - getX(), v.getY() - getY());}
    public boolean equal(double radius, Vector v) {return distanceToVector(v) < radius;}

    public Vector setName(String name) {
        this.name = name;
        return this;
    }

    @NonNull
    @Override
    public String toString() {return String.format(US, "%s:\nX: %.2f\nY: %.2f", name, x, y);}
}
