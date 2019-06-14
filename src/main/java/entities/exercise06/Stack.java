package entities.exercise06;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private List<T> ts = new ArrayList<>();

    public boolean isEmpty() {
        return ts.isEmpty();
    }

    public void push(T x) {
        ts.add(x);
    }

    public T pop() {
        T result = ts.get(ts.size() - 1);
        ts.remove(ts.get(ts.size() - 1));
        return result;
    }
}
