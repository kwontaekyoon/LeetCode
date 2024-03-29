class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length, max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
        }
        long res = 0;
        for (int l = 0, r = 0, c = 0; r < n; r++) {
            if (nums[r] == max) {
                c++;
            }
            while (c >= k) {
                if (nums[l] == max) {
                    c--;
                }
                res += n - r;
                l++;
            }
        }
        return res;
    }
}