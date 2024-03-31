class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        var cnt = 0L;
        int maxi = -1, mini = -1;
        int n = nums.length;
        for (int l = 0, r = 0; r < n; r++) {
            if (nums[r] < minK || nums[r] > maxK) {
                l = r + 1;
                continue;
            }
            if (nums[r] == maxK) {
                maxi = r;
            }
            if (nums[r] == minK) {
                mini = r;
            }
            cnt += Math.max(Math.min(maxi, mini) - l + 1, 0);
        }
        return cnt;
    }
}