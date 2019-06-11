package exercise02;

public class Circle implements Shape {

    private double r;

    Circle(double r) {
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
    public String toString() {
        return showInfo();
    }
}
