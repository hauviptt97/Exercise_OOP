package exercise02Test;

import entities.exercise02.Quadrilateral;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuadrilateralTest {
    @Test
    public void test_getDistance() {
        assertEquals(new Quadrilateral(0, 0, 0, 0, 0, 0, 0, 0).getDistance(0, 3, 4, 0), 5.0);
    }

    @Test
    public void test_isValid() {
        assertTrue(new Quadrilateral(1, 3, 2, 1, 3, 4,1,1).isValid());
        assertFalse(new Quadrilateral(2, 3, 2, 1, 2, 1,3,2).isValid());
        assertTrue(new Quadrilateral(4, 2, 3, 6, 7, -1,3,3).isValid());
        assertTrue(new Quadrilateral(0, 0, 0, 3, 6, 0,0,5).isValid());
        assertTrue(new Quadrilateral(0, 4, 0, 2, 2, 4,6,2).isValid());
        assertTrue(new Quadrilateral(0, 2, 0, 8, 8, 2,3,5).isValid());
        assertFalse(new Quadrilateral(0, 0, 4, 0, 2, 2,0,0).isValid());
    }

    @Test
    public void test_getType(){
        assertEquals(new Quadrilateral(2, 3, 2, 1, 2, 1, 2, 2).getType(),"Invalid Quadrilateral");
        assertEquals(new Quadrilateral(0, 2, 2, 2, 2, 0, 0, 0).getType(), "Quadrilateral");
    }

    @Test
    public void test_getAreaOfTriangle() {
        assertEquals(new Quadrilateral(0, 0, 0, 0, 0, 0, 0, 0).getAreaOfTriangle(3,4,5), 6.0);
    }

    @Test
    public void test_getArea() {
        assertEquals(new Quadrilateral(2, 3, 2, 1, 2, 1, 2, 2).getArea(), -1.0);
        assertEquals(new Quadrilateral(2, 2, 4, 2, 2, 0, 0, 0).getArea(), 3.999999999999997);
        assertEquals(new Quadrilateral(0, 2, 4, 2, 6, 0, 2, 0).getArea(), 7.999999999999987);
        assertEquals(new Quadrilateral(0, 2, 2, 2, 2, 0, 0, 0).getArea(), 3.9999999999999987);
    }

    @Test
    public void test_getPerimeter() {
        assertEquals(new Quadrilateral(2, 3, 2, 1, 2, 1, 2, 2).getPerimeter(), -1.0);
        assertEquals(new Quadrilateral(0, 2, 2, 2, 2, 0, 0, 0).getPerimeter(), 8.0);
    }

    @Test
    public void test_toString() {
        assertEquals(new Quadrilateral(2, 3, 2, 1, 2, 1, 2, 2).toString(), "Type: " + "Invalid Quadrilateral" + "\nArea: " + -1.0 + "\nPerimeter: " + -1.0);
        assertEquals(new Quadrilateral(0, 2, 2, 2, 2, 0, 0, 0).toString(), "Type: " + "Quadrilateral" + "\nArea: " + 3.9999999999999987 + "\nPerimeter: " + 8.0);
    }
}
