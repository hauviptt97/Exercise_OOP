package controllers.exercise02;

import entities.exercise02.Circle;
import entities.exercise02.Quadrilateral;
import interfaces.exercise02.Shape;
import entities.exercise02.Triangle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShapeFactory {

    public List<Shape> getData(String input) {

        List<Shape> shapes = new ArrayList<>();

        for (String lineData : input.split("[\n]+")) {

            Shape shape = null;

            List<Integer> data = Stream.of(lineData.split("[, ]+"))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());


            if (data.size() == 3) {
                shape = new Circle(data.get(2));
            } else if (data.size() == 6) {
                shape = new Triangle(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5));
            } else if (data.size() == 8) {
                shape = new Quadrilateral(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5), data.get(6), data.get(7));
            }

            if (shape != null) {
                shapes.add(shape);
            }
        }

        return shapes;
    }

    public void showData(List<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println("===================================");
        }
    }
}
