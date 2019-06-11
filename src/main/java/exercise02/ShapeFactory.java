package exercise02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ShapeFactory {

    List<Shape> getData(String input) {

        List<Shape> shapes = new ArrayList<>();

        for (String lineData : input.split("[\n]+")) {

            List<Integer> data = new ArrayList<>();

            Shape obj = null;

            try {
                data = Stream.of(lineData.split("[, ]+"))
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());

            } catch (NumberFormatException ignored) {
            }

            if (data.size() == 3) {
                obj = new Circle(data.get(2));
            } else if (data.size() == 6) {
                obj = new Triangle(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5));
            } else if (data.size() == 8) {
                obj = new Quadrilateral(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5), data.get(6), data.get(7));
            }

            if (obj != null) {
                shapes.add(obj);
            }

        }
        return shapes;
    }

    void showData(List<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println("===================================");
        }
    }
}
