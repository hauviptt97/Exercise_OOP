package entities.exercise02;

import interfaces.exercise02.Shape;
import utils.MathUtils;

public class Quadrilateral implements Shape {

    private double a;
    private double b;
    private double c;
    private double d;
    private double g;
    private double h;

    public Quadrilateral(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        this.a = getDistance(x1, y1, x2, y2);
        this.b = getDistance(x2, y2, x3, y3);
        this.c = getDistance(x3, y3, x4, y4);
        this.d = getDistance(x1, y1, x4, y4);
        this.g = getDistance(x1, y1, x3, y3);
        this.h = getDistance(x2, y2, x4, y4);
    }

    @Override
    public boolean isValid() {
        return a * b * c * d != 0 && 2 * MathUtils.max(a, b, c, d) < (a + b + c + d);
    }

    public String getType() {
        if (!isValid()) {
            return "Invalid Quadrilateral";
        }
        return "Quadrilateral";
    }

    public double getDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double getAreaOfTriangle(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
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

        double s1 = getAreaOfTriangle(a, b, g) + getAreaOfTriangle(c, d, g);
        double s2 = getAreaOfTriangle(a, d, h) + getAreaOfTriangle(c, b, h);
        return s1 <= s2 ? s1 : s2;
    }

    @Override
    public double getPerimeter() {
        if (!isValid()) {
            return -1;
        }
        return a + b + c + d;
    }



    @Override
    public String toString() {
        return showInfo();
    }
}
