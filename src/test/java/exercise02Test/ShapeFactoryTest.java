package exercise02Test;

import controllers.exercise02.ShapeFactory;
import interfaces.exercise02.Shape;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class ShapeFactoryTest {

    @Test
    public void test_getData() {
        List<Shape> test = new ShapeFactory().getData("1,3,5\n0,1,2,0,0,0\n1,1,2,2,3,3,4,4\n2,3,6\n");
        System.out.println(test.toString());
        TestCase.assertEquals(test.size(), 4);
    }

}
