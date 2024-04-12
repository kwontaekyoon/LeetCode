class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        var prefixMax = new int[n];
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }
        var suffixMax = new int[n];
        suffixMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i > -1; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
        }
        var res = 0L;
        for (int i = 1; i < n - 1; i++) {
            res = Math.max(res, (prefixMax[i - 1] - nums[i]) * (long) suffixMax[i + 1]);
        }
        return res;
    }
}