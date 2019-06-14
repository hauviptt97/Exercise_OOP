package exercise06;

import entities.exercise06.Stack;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class StackTest {

    @Test
    public void test_isEmpty() {
        assertTrue(new Stack().isEmpty());
    }

    @Test
    public void test_push() {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        assertFalse(s.isEmpty());
    }

    @Test
    public void test_pop() {
        Stack<Integer> s = new Stack<>();
        s.push(12);
        s.push(16);
        s.push(14);
        assertEquals((int) s.pop(), 14);
    }
}
