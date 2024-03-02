class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int[] res = new int[n];
        while (l <= r) {
            n--;
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                res[n] = nums[l] * nums[l];
                l++;
            } else {
                res[n] = nums[r] * nums[r];
                r--;
            }
        }
        return res;
    }
}