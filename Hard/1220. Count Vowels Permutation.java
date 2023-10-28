class Solution {
    private final static int MOD = (int) 1e9 + 7;

    public int countVowelPermutation(int n) {
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        // long[][] dp = new long[n][5];
        // Arrays.fill(dp[0], 1);
        for (int r = 1; r < n; r++) {
            long nextA = (e + i + u) % MOD;
            long nextE = (a + i) % MOD;
            long nextI = (e + o) % MOD;
            long nextO = (i) % MOD;
            long nextU = (i + o) % MOD;
            a = nextA;
            e = nextE;
            i = nextI;
            o = nextO;
            u = nextU;
            // for (int c = 0; c < 5; c++) {
            // if (c == 0) { // end with a
            // dp[r][c] = (dp[r - 1][1] + dp[r - 1][2] + dp[r - 1][4]) % MOD;
            // } else if (c == 1) { // end with e
            // dp[r][c] = (dp[r - 1][0] + dp[r - 1][2]) % MOD;
            // } else if (c == 2) { // end with i
            // dp[r][c] = (dp[r - 1][1] + dp[r - 1][3]) % MOD;
            // } else if (c == 3) { // end with o
            // dp[r][c] = dp[r - 1][2];
            // } else if (c == 4) { // end with u
            // dp[r][c] = (dp[r - 1][2] + dp[r - 1][3]) % MOD;
            // }
            // }
        }
        // return (int) ((dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2] + dp[n - 1][3] +
        // dp[n - 1][4]) % MOD);
        return (int) ((a + e + i + o + u) % MOD);
    }
}
/**
 * brute force
 * class Solution {
 * private final static int MOD = (int) 1e9 + 7;
 * private int cnt = 0;
 * 
 * private void dfs(char cur, int len, int target) {
 * if (len == target) {
 * this.cnt = (this.cnt + 1) % MOD;
 * } else {
 * if (cur == 'a') {
 * dfs('e', len + 1, target);
 * } else if (cur == 'e') {
 * dfs('a', len + 1, target);
 * dfs('i', len + 1, target);
 * } else if (cur == 'i') {
 * for (char c : List.of('a', 'e', 'o', 'u')) {
 * dfs(c, len + 1, target);
 * }
 * } else if (cur == 'o') {
 * dfs('i', len + 1, target);
 * dfs('u', len + 1, target);
 * } else {
 * dfs('a', len + 1, target);
 * }
 * }
 * }
 * 
 * public int countVowelPermutation(int n) {
 * for (char start : List.of('a', 'e', 'i', 'o', 'u')) {
 * dfs(start, 1, n);
 * }
 * return cnt;
 * }
 * }
 */