class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0, p = 1; i < n; i++) {
            res[i] = p;
            p *= nums[i];
        }
        for (int i = n - 1, p = 1; i > -1; i--) {
            res[i] *= p;
            p *= nums[i];
        }
        return res;
    }
}