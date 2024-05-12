class Solution {
    public boolean validPartition(int[] nums) {
        final int N = nums.length;
        final var dp = new boolean[N + 1];
        dp[0] = true;
        for (int i = 0; i < N; i++) {
            if (!dp[i]) {
                continue;
            }
            if (i + 1 < N) {
                if (nums[i] == nums[i + 1]) {
                    dp[i + 2] = true;
                }
            }
            if (i + 2 < N) {
                if ((nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) ||
                        (nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2])) {
                    dp[i + 3] = true;
                }
            }
        }
        return dp[N];
    }
}