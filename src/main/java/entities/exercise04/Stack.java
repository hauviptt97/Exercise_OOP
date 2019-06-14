package entities.exercise04;


public class Stack {
    private static final int MAX = 22;
    private int top;
    private int numbers[] = new int[MAX]; // Maximum size of Stack

    public Stack() {
        top = -1;
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public boolean push(int x) {
        if (top >= (MAX - 1)) {
            return false;
        } else {
            numbers[++top] = x;
            return true;
        }
    }

    public int pop() {
        if (top < 0) {
            return 0;
        } else {
            return numbers[top--];
        }
    }

}
