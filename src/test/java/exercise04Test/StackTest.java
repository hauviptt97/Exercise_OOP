package exercise04Test;

import entities.exercise04.StackNumber;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class StackTest {

    @Test
    public void test_isEmpty() {
        assertTrue(new StackNumber().isEmpty());
    }

    @Test
    public void test_push() {
        StackNumber s = new StackNumber();
        s.push(10);
        s.push(20);
        assertFalse(s.isEmpty());
    }

    @Test
    public void test_pop() {
        StackNumber s = new StackNumber();
        assertEquals(s.pop(), -1);
        s.push(12);
        s.push(16);
        s.push(14);
        assertEquals(s.pop(), 14);
    }
}
