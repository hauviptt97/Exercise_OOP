package exercise02Test;

import controllers.exercise02.ShapeFactory;
import interfaces.exercise02.Shape;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class ShapeFactoryTest {

    @Test
    public void test_getData() {
        List<Shape> test1 = new ShapeFactory().getData("1,2\n1,3,5\n0,1,2,0,0,0\n1,1,2,2,3,3,4,4\n2,3,6\n");
        List<Shape> test2 = new ShapeFactory().getData("1");
        TestCase.assertEquals(test1.size(), 4);
        TestCase.assertEquals(test2.size(), 0);

    }

}
