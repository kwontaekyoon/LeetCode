class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, res = 0, len = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        for (int num : nums) {
            res = Math.max(res, len = num < max ? 0 : len + 1);
        }
        return res;
    }
}