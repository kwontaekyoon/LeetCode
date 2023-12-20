class Solution {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int maxLen = 0, n = chars.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(i - stack.peek(), maxLen);
                }
            }
        }
        return maxLen;
    }
}