import java.util.ArrayDeque;

class Solution {
    public int minLength(String s) {
        final var stack = new char[s.length()];
        int top = -1;
        for (var c : s.toCharArray()) {
            if (top == -1) {
                stack[++top] = c;
                continue;
            }
            if (stack[top] == 'A' && c == 'B') {
                top--;
                continue;
            }
            if (stack[top] == 'C' && c == 'D') {
                top--;
                continue;
            }
            stack[++top] = c;
        }
        return top + 1;
    }
}

class Solution1 {
    public int minLength(String s) {
        final var stack = new ArrayDeque<Character>();
        for (var c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.offerLast(c);
                continue;
            }
            if ((stack.peekLast() == 'A' && c == 'B') || (stack.peekLast() == 'C' && c == 'D')) {
                stack.pollLast();
            } else {
                stack.offerLast(c);
            }
        }
        return stack.size();
    }
}