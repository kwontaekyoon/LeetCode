class Solution {
    private void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }

    public int[] sortArrayByParity(int[] nums) {
        // for looping
        // for (int i = 0, pt = 0; i < nums.length; i++) {
        // if (nums[i] % 2 == 0) {
        // swap(nums, pt++, i);
        // }
        // }

        // two pointer
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 1) {
                right--;
            }
            swap(nums, left, right);
        }
        return nums;
    }
}