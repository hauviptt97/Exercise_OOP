package exercise02Test;

import entities.exercise02.Triangle;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TriangleTest {

    @Test
    public void test_getDistance() {
        assertEquals(Triangle.getDistance(0, 3, 4, 0), 5.0);
    }

    @Test
    public void test_isValid() {
        assertTrue(new Triangle(1, 3, 2, 1, 3, 4).isValid());
        assertFalse(new Triangle(2, 3, 2, 1, 2, 1).isValid());
        assertTrue(new Triangle(4, 2, 3, 6, 7, -1).isValid());
        assertTrue(new Triangle(0, 0, 0, 3, 6, 0).isValid());
        assertTrue(new Triangle(0, 4, 0, 2, 2, 4).isValid());
        assertTrue(new Triangle(0, 2, 0, 8, 8, 2).isValid());
        assertTrue(new Triangle(0, 0, 4, 0, 2, 2).isValid());
    }

    @Test
    public void test_getType() {
        assertEquals(new Triangle(2, 3, 2, 1, 2, 1).getType(), "Invalid Triangle");
        assertEquals(new Triangle(-3, 0, 0, 3 * Math.sqrt(3), 3, 0).getType(), "Equilateral Triangle");
        assertEquals(new Triangle(0, 0, 0, 3, 4, 0).getType(), "Right Triangle");
        assertEquals(new Triangle(4, 0, 0, 0, 0, 3).getType(), "Right Triangle");
        assertEquals(new Triangle(0, 3, 4, 0, 0, 0).getType(), "Right Triangle");
        assertEquals(new Triangle(4, 2, 3, 6, 7, -1).getType(), "Scalene Triangle");
        assertEquals(new Triangle(1, 3, 2, 1, 3, 4).getType(), "Isosceles Triangle");
    }

    @Test
    public void test_getArea() {
        assertEquals(new Triangle(2, 3, 2, 8, 2, 1).getArea(), -1.0);
        assertEquals(new Triangle(0, 0, 0, 3, 6, 0).getArea(), 9.0);
    }

    @Test
    public void test_getPerimeter() {
        assertEquals(new Triangle(2, 3, 2, 8, 2, 1).getPerimeter(), -1.0);
        assertEquals(new Triangle(1, 3, 2, 1, 3, 4).getPerimeter(), 7.63441361516796);
    }

    @Test
    public void test_toString() {
        assertEquals(new Triangle(2, 3, 2, 1, 2, 1).toString(), "Type: " + "Invalid Triangle" + "\nArea: " + -1.0 + "\nPerimeter: " + -1.0);
        assertEquals(new Triangle(-3, 0, 0, 3 * Math.sqrt(3), 3, 0).toString(), "Type: " + "Equilateral Triangle" + "\nArea: " + 15.588457268119896 + "\nPerimeter: " + 18.0);
    }
}
