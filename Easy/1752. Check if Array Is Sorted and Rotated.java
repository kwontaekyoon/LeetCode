class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        boolean piv = nums[0] < nums[n - 1] ? true : false;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                if (piv) {
                    return false;
                }
                piv = true;
            }
        }
        return true;
    }
}
