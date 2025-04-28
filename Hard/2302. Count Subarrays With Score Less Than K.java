// Sliding Window, Two Pointers, Prefix Sum -> O(N)
class Solution {
    public long countSubarrays(int[] nums, long k) {
        long result = 0, prefix = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            prefix += nums[r];
            while (l <= r && prefix * (r - l + 1) >= k) {
                prefix -= nums[l];
                l++;
            }
            result += r - l + 1;
        }
        return result;
    }
}