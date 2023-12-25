class Solution {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (chars[0] == '0') {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = dp[1] = 1;

        for (int i = 1; i < len; i++) {
            if (chars[i] > '0') {
                dp[i + 1] += dp[i];
            }
            if (chars[i - 1] == '1') {
                dp[i + 1] += dp[i - 1];
            }
            if (chars[i - 1] == '2' && chars[i] <= '6') {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[len];
    }
}