// dp
class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] rightBounds = new int[n];
        rightBounds[n - 1] = n;
        for (int i = n - 2; i > -1; i--) {
            int b = i + 1;
            while (b < n && temps[b] <= temps[i]) {
                b = rightBounds[b];
            }
            rightBounds[i] = b;
        }
        for (int i = 0; i < n; i++) {
            if (rightBounds[i] == n) {
                rightBounds[i] = 0;
            } else {
                rightBounds[i] -= i;
            }
        }
        return rightBounds;
    }
}
// stack
class Solution {
    public int[] dailyTemperatures(int[] temps) {
        // brute force -> n^2
        // stack
        int n = temps.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                int d = stack.pop();
                res[d] = i - d;
            }
            stack.push(i);
        }
        return res;
    }
}