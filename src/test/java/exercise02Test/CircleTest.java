package exercise02Test;

import entities.exercise02.Circle;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CircleTest {
    @Test
    public void test_isValid() {
        assertTrue(new Circle(3).isValid());
        assertFalse(new Circle(-1).isValid());
    }

    @Test
    public void test_getType() {
        assertEquals(new Circle(-1).getType(), "Invalid Circle");
        assertEquals(new Circle(1).getType(), "Circle");
    }

    @Test
    public void test_getArea() {
        assertEquals(new Circle(-1).getArea(), -1.0);
        assertEquals(new Circle(1).getArea(), Math.PI);
    }

    @Test
    public void test_getPerimeter() {
        assertEquals(new Circle(-1).getPerimeter(), -1.0);
        assertEquals(new Circle(1).getPerimeter(), Math.PI * 2);
    }

    @Test
    public void test_toString() {
        assertEquals(new Circle(-1).toString(), "Type: " + "Invalid Circle" + "\nArea: " + -1.0 + "\nPerimeter: " + -1.0);
        assertEquals(new Circle(1).toString(), "Type: " + "Circle" + "\nArea: " + Math.PI + "\nPerimeter: " + Math.PI * 2);
    }

}
