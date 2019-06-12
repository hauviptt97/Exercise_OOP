package entities.exercise02;

import interfaces.exercise02.Shape;

public class Circle implements Shape {

    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public String getType() {
        if (!isValid()) {
            return "Invalid Circle";
        }
        return "Circle";
    }

    @Override
    public String showInfo() {
        return "Type: " + getType() + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter();
    }

    @Override
    public double getArea() {
        if (!isValid()) {
            return -1;
        }
        return Math.PI * r * r;
    }

    @Override
    public double getPerimeter() {
        if (!isValid()) {
            return -1;
        }
        return Math.PI * r * 2;
    }

    @Override
    public boolean isValid() {
        return r > 0;
    }

    @Override
    public String toString() {
        return showInfo();
    }
}
