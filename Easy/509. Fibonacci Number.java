class Solution {
    private int dp(int[] memo, int n) {
        if (n <= 1) {
            return memo[n] = n;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        return memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
    }

    public int fib(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(memo, n);
    }
}