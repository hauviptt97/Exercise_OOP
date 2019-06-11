package entities.exercise02;

import interfaces.exercise02.Shape;

public class Triangle implements Shape {

    private double a;
    private double b;
    private double c;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.a = getDistance(x1, y1, x2, y2);
        this.b = getDistance(x1, y1, x3, y3);
        this.c = getDistance(x2, y2, x3, y3);
    }

    private double getDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    private String getType() {

        if (!isValid()) {
            return "Invalid Triangle";
        }

        if (a == b && a == c) {
            return "Equilateral Triangle";
        }

        if ((a - b) * (a - c) * (b - c) != 0) {

            if (c * c == a * a + b * b || b * b == a * a + c * c || a * a == c * c + b * b) {
                return "Right Triangle";
            }

            return "Scalene Triangle";
        }
        return " Isosceles Triangle";
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

        double p = getPerimeter() / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double getPerimeter() {
        if (!isValid()) {
            return -1;
        }

        return a + b + c;
    }

    @Override
    public boolean isValid() {
        return a * b * c != 0 && a + b > c && a + c > b && b + c > a;
    }

    @Override
    public String toString() {
        return showInfo();
    }
}
