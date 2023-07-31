class Solution {
    private int dp(String s1, String s2) {
        int[][] dp = new int[s2.length() + 1][s1.length() + 1];
        for (int row = 0; row < s2.length() + 1; row++) {
            for (int col = 0; col < s1.length() + 1; col++) {
                if (row == 0 || col == 0) {
                    dp[row][col] = 0;
                } else if (s1.charAt(col - 1) == s2.charAt(row - 1)) {
                    dp[row][col] = dp[row - 1][col - 1] + (int) s1.charAt(col - 1);
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }
        return dp[s2.length()][s1.length()];
    }

    private int stringToAsciiSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += (int) c;
        }
        return sum;
    }

    public int minimumDeleteSum(String s1, String s2) {
        return stringToAsciiSum(s1) + stringToAsciiSum(s2) - dp(s1, s2) * 2;
    }
}