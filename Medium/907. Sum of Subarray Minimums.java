class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int MOD = 1000000007;
        Deque<Integer> stack = new ArrayDeque<>();
        long sum = 0;
        int n = arr.length;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] >= arr[i])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long cnt = (mid - left) * (right - mid) % MOD;

                sum = (sum + (cnt * arr[mid]) % MOD) % MOD;
            }
            stack.push(i);
        }

        return (int) sum;
    }
}