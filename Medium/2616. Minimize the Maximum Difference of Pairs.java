class Solution {
    public int minimizeMax(int[] nums, int p) {
        final int N = nums.length;
        Arrays.sort(nums);
        int left = 0, right = nums[N - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 1; i < N; i++) {
                if (nums[i] - nums[i - 1] <= mid) {
                    i++;
                    cnt++;
                }
            }
            if (cnt < p) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}