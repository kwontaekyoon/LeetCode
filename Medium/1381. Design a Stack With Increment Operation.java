class CustomStack {
    private final int MAX_SIZE;
    private final int[] stack;
    private final int[] increment;
    private int top;

    public CustomStack(int maxSize) {
        MAX_SIZE = maxSize;
        stack = new int[MAX_SIZE];
        increment = new int[MAX_SIZE];
        top = -1;
    }

    public void push(int x) {
        if (top + 1 < MAX_SIZE) {
            stack[++top] = x;
        }
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        if (top > 0) {
            increment[top - 1] += increment[top];
        }
        int topVal = stack[top] + increment[top];
        increment[top--] = 0;
        return topVal;
    }

    public void increment(int k, int val) {
        if (top > -1) {
            increment[Math.min(k - 1, top)] += val;
        }
    }
}

class CustomStack1 {
    private final int SIZE;
    private final int[] stack;
    private int top;

    public CustomStack1(int maxSize) {
        SIZE = maxSize;
        stack = new int[SIZE];
        top = -1;
    }

    public void push(int x) {
        if (top + 1 < SIZE) {
            stack[++top] = x;
        }
    }

    public int pop() {
        return top == -1 ? -1 : stack[top--];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(top + 1, k); i++) {
            stack[i] += val;
        }
    }
}