import java.util.ArrayDeque;

class Solution {
    public String reverseParentheses(String s) {
        final var chars = s.toCharArray();
        final var n = chars.length;
        final var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                reverse(chars, stack.pop(), i);
            }
        }
        final var sb = new StringBuilder();
        for (var c : chars) {
            if (c == '(' || c == ')') {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private void reverse(char[] chars, int l, int r) {
        while (l < r) {
            var tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
    }
}