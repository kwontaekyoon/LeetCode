import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        final var res = new ArrayList<Integer>();
        for (int i = 0; i < expression.length(); i++) {
            final var oper = expression.charAt(i);
            if (oper == '+' || oper == '-' || oper == '*') {
                final var s1 = diffWaysToCompute(expression.substring(0, i));
                final var s2 = diffWaysToCompute(expression.substring(i + 1));
                for (int a : s1) {
                    for (int b : s2) {
                        if (oper == '+') {
                            res.add(a + b);
                        } else if (oper == '-') {
                            res.add(a - b);
                        } else {
                            res.add(a * b);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}