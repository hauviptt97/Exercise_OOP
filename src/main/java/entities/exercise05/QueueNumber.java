package entities.exercise05;

import java.util.ArrayList;
import java.util.List;

public class QueueNumber {
    private List<Integer> numbers = new ArrayList<>();

    public boolean isEmpty() {
        return numbers.isEmpty();
    }

    public void enqueue(int number) {
        numbers.add(number);
    }

    public int dequeue() {
        int result = numbers.get(0);
        numbers.remove(0);
        return result;
    }

    public int peek() {
        return numbers.get(0);
    }

}
