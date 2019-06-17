package exercise07test;

import entities.exercise07.Queue;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class QueueTest {

    @Test
    public void test_isEmpty() {
        assertTrue(new Queue<>().isEmpty());
    }

    @Test
    public void test_enqueue() {
        Queue<Integer> queueNumber = new Queue<>();
        queueNumber.enqueue(1);
        assertFalse(queueNumber.isEmpty());
    }

    @Test
    public void test_dequeue() {
        Queue<Number> queueNumber = new Queue<>();
        assertNull(queueNumber.dequeue());
        queueNumber.enqueue(1);
        queueNumber.enqueue(2);
        queueNumber.enqueue(2);
        assertEquals(queueNumber.dequeue(), 1);
    }

    @Test
    public void test_peek() {
        Queue<Number> queueNumber = new Queue<>();
        assertNull(queueNumber.peek());
        queueNumber.enqueue(2);
        queueNumber.enqueue(4);
        assertEquals(queueNumber.peek(), 2);
    }

}
