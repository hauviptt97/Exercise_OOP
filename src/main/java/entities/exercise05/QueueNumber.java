package entities.exercise05;

import java.util.ArrayList;
import java.util.List;

public class QueueNumber {
    private List<Number> numbers = new ArrayList<>();

    public boolean isEmpty() {
        return numbers.isEmpty();
    }

    public void enqueue(int number) {
        numbers.add(number);
    }

    public Number dequeue() {
        if (!numbers.isEmpty()) {
            Number result = numbers.get(0);
            numbers.remove(0);
            return result;
        }

        return -1;
    }

    public Number peek() {
        if (numbers.isEmpty()) {
            return -1;
        }
        return numbers.get(0);
    }

}
