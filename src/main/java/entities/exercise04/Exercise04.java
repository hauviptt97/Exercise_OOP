package entities.exercise04;

public class Exercise04 {

    class Stack {
        static final int MAX = 1000;
        int top;
        int numbers[] = new int[MAX]; // Maximum size of Stack

        boolean isEmpty() {
            return (top < 0);
        }

        Stack() {
            top = -1;
        }

        boolean push(int x) {
            if (top >= (MAX - 1)) {
                System.out.println("Stack Overflow");
                return false;
            } else {
                numbers[++top] = x;
                System.out.println(x + " pushed into stack");
                return true;
            }
        }

        int pop() {
            if (top < 0) {
                System.out.println("Stack Underflow");
                return 0;
            } else {
                int x = numbers[top--];
                return x;
            }
        }
    }

}
