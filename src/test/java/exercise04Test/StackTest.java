package exercise04Test;

import entities.exercise04.Stack;
import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class StackTest {

    @Test
    public void test_isEmpty() {
        assertTrue(new Stack().isEmpty());
    }

    @Test
    public void test_push() {
        Stack s = new Stack();
        assertTrue(s.push(10));
        assertTrue(s.push(20));
        for (int i = 0; i < 20 ;i++){
            s.push(12);
        }
        assertFalse(s.push(25));
    }

    @Test
    public void test_pop() {
        Stack s = new Stack();
        assertEquals(s.pop(),0);
        s.push(12);
        s.push(16);
        s.push(14);
        assertEquals(s.pop(),14);
    }
}
