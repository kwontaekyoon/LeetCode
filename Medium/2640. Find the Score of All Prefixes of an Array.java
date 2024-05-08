class Solution {
    public long[] findPrefixScore(int[] nums) {
        final int N = nums.length;
        for (int i = 0, m = 0; i < N; i++) {
            nums[i] += m = Math.max(m, nums[i]);
        }
        var prefixSum = 0L;
        final var res = new long[N];
        for (int i = 0; i < N; i++) {
            res[i] = prefixSum += nums[i];
        }
        return res;
    }
}