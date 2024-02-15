class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += nums[i];
        }
        for (int b = n - 1; b > 1; b--) {
            if (sum > nums[b]) {
                return sum + nums[b];
            }
            sum -= nums[b - 1];
        }
        return -1;
    }
}