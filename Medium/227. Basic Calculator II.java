class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        int ope = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (isOpe(c) || i == s.length() - 1) {
                if (ope == '+') {
                    stack.push(num);
                } else if (ope == '-') {
                    stack.push(-num);
                } else if (ope == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                ope = c;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
    private boolean isOpe(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}