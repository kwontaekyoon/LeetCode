class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] divided = new int[nums.length / 3][3];
        for (int r = 0; r < divided.length; r++) {
            if (nums[r * 3 + 2] - nums[r * 3] > k) {
                return new int[][] {};
            }
            for (int c = 0; c < 3; c++) {
                divided[r][c] = nums[r * 3 + c];
            }
        }
        return divided;
    }
}