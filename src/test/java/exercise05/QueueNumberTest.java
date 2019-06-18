package exercise05;

import entities.exercise05.QueueNumber;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class QueueNumberTest {

    @Test
    public void test_isEmpty() {
        assertTrue(new QueueNumber().isEmpty());
    }

    @Test
    public void test_enqueue() {
        QueueNumber queueNumber = new QueueNumber();
        queueNumber.enqueue(1);
        assertFalse(queueNumber.isEmpty());
    }

    @Test
    public void test_dequeue() {
        QueueNumber queueNumber = new QueueNumber();
        assertEquals(queueNumber.dequeue(), -1);
        queueNumber.enqueue(1);
        queueNumber.enqueue(2);
        queueNumber.enqueue(2);
        assertEquals(queueNumber.dequeue(), 1);
    }

    @Test
    public void test_peek() {
        QueueNumber queueNumber = new QueueNumber();
        assertEquals(queueNumber.peek(), -1);
        queueNumber.enqueue(2);
        queueNumber.enqueue(4);
        assertEquals(queueNumber.peek(), 2);
    }

}
