class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] preMax = new int[n];
        preMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }
        int[] sufMin = new int[n];
        sufMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufMin[i] = Math.min(sufMin[i + 1], nums[i]);
        }
        int[] result = new int[n];
        result[n - 1] = preMax[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (preMax[i] > sufMin[i + 1]) {
                result[i] = result[i + 1];
            } else {
                result[i] = preMax[i];
            }
        }
        return result;
    }
}
