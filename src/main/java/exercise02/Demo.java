package exercise02;

import java.util.List;

public class Demo {

    public static void main(String[] args) {

        ShapeFactory sf = new ShapeFactory();

        String input = "1-,\n1sa\n1,2,4\n0, 0, 0, 3, 6, 0\n1, 3, 2, 1, 3, 4\n\n4, 2, 3, 6, 7, -1,5,5\n-2,2,4";

        List<Shape> shapes = sf.getData(input);

        sf.showData(shapes);

    }

}
