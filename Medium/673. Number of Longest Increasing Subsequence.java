class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        int maxLen = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    } else if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == maxLen)
                res += cnt[i];
        }
        return res;
    }
}