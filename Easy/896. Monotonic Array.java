class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }
        boolean isNotDecreasing = nums[nums.length - 1] - nums[0] >= 0;
        for (int i = 1; i < nums.length; i++) {
            if (isNotDecreasing) {
                if (nums[i] - nums[i - 1] < 0) {
                    return false;
                }
            } else {
                if (nums[i] - nums[i - 1] > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}