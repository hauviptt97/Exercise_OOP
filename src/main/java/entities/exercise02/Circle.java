package entities.exercise02;

import interfaces.exercise02.Shape;

public class Circle implements Shape {

    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public String showInfo() {
        return "Type: " + "Circle" + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter();
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }

    @Override
    public double getPerimeter() {
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
