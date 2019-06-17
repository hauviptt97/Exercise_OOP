package entities.exercise07;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    private List<T> ts = new ArrayList<>();

    public boolean isEmpty() {
        return ts.isEmpty();
    }

    public void enqueue(T x) {
        ts.add(x);
    }

    public T dequeue() {

        if (ts.isEmpty()) {
            return null;
        }

        T result = ts.get(0);
        ts.remove(0);
        return result;
    }

    public T peek() {
        if (ts.isEmpty()) {
            return null;
        }

        return ts.get(0);
    }

}