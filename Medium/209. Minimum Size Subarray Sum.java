// sliding window O(n), O(1)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int windowSize = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                sum -= nums[i];
                windowSize = Math.min(windowSize, j - i + 1);
                i++;
            }
            j++;
        }
        return windowSize != Integer.MAX_VALUE ? windowSize : 0;
    }
}