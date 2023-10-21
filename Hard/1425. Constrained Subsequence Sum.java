class Solution {
    // private int dfs(int[] memo, int[] nums, int idx, int limit) {
    // if (idx < 0) {
    // return 0;
    // }
    // if (memo[idx] != (int) -1e9) {
    // return memo[idx];
    // }
    // int maxVal = 0;
    // for (int l = 1; l <= limit; l++) {
    // maxVal = Math.max(dfs(memo, nums, idx - l, limit), maxVal);
    // }
    // return memo[idx] = nums[idx] + maxVal;
    // }

    // public int constrainedSubsetSum(int[] nums, int k) {
    // int n = nums.length;
    // int[] memo = new int[n];
    // Arrays.fill(memo, (int) -1e9);
    // memo[0] = nums[0];
    // int maxSum = (int) -1e9;
    // for (int i = n - 1; i > -1; i--) {
    // maxSum = Math.max(dfs(memo, nums, i, k), maxSum);
    // }
    // return maxSum;
    // }
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] += dq.isEmpty() ? 0 : nums[dq.peekFirst()];

            while (!dq.isEmpty() && (i - dq.peekFirst() >= k || nums[i] >= nums[dq.peekLast()])) {
                if (nums[i] >= nums[dq.peekLast()]) {
                    dq.pollLast();
                } else {
                    dq.pollFirst();
                }
            }

            if (nums[i] > 0) {
                dq.offerLast(i);
            }
        }
        int maxSum = (int) -1e9;
        for (int num : nums) {
            maxSum = Math.max(num, maxSum);
        }
        return maxSum;
    }
}