class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }
        // final var memo = new int[n + 1];
        // memo[1] = 1;
        // memo[2] = 1;
        // memo[3] = 2;
        // int sum = 2;
        // for (int i = 4; i <= n; i++) {
        //     sum -= memo[i - 4];
        //     sum += memo[i - 1];
        //     memo[i] = sum;
        // }
        // return memo[n];
        
        // int a = 0, b = 1, c = 1;
        // int next;

        // for (int i = 3; i <= n; i++) {
        //     next = a + b + c;
        //     a = b;
        //     b = c;
        //     c = next;
        // }

        // return c;

        final var memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 1;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }

        return memo[n];
    }
}