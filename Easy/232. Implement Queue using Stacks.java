class MyQueue {
    private Deque<Integer> stack;
    private Deque<Integer> tmp;

    public MyQueue() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        tmp = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        stack.push(x);
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */