class Solution {
    public void rotate(int[] nums, int k) {
        final int N = nums.length;
        final int K = k % N;
        reverse(nums, 0, N - 1);
        reverse(nums, 0, K - 1);
        reverse(nums, K, N - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}