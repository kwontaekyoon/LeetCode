// Array, Sliding Window -> O(N)
class Solution {
    public int countSubarrays(int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if ((nums[i - 1] + nums[i + 1]) * 2 == nums[i]) {
                result += 1;
            }
        }
        return result;
    }
}