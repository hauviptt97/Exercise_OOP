package entities.exercise04;


import java.util.ArrayList;
import java.util.List;

public class StackNumber {
    private List<Number> ts = new ArrayList<>();

    public boolean isEmpty() {
        return ts.isEmpty();
    }

    public void push(Number x) {
        ts.add(x);
    }

    public Number pop() {

        if (!ts.isEmpty()) {
            Number result = ts.get(ts.size() - 1);
            ts.remove(ts.get(ts.size() - 1));
            return result;
        }
        return -1;
    }
}
