class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int u = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[u++] = nums[i];
            }
        }
        int ans = nums.length;
        for (int i = 0, j = 0; i < u; i++) {
            while (j < u && nums[j] - nums[i] <= n - 1) {
                j++;
            }
            ans = Math.min(ans, n - j + i);
        }
        return ans;
    }
}

/**
 * sliding window using deque
 * class Solution {
 * public int minOperations(int[] nums) {
 * Arrays.sort(nums); // Sort the array
 * 
 * int n = nums.length;
 * int maxNumsInWindow = 0;
 * 
 * Deque<Integer> numsInWindow = new ArrayDeque<>();
 * for (int num : nums) {
 * // Advance the window
 * while (numsInWindow.size() > 0 && num - numsInWindow.peekFirst() >= n) {
 * numsInWindow.poll();
 * }
 * 
 * // Add the new number to the window (if it's not a duplicate)
 * if(numsInWindow.size() == 0 || !numsInWindow.peekLast().equals(num)) {
 * numsInWindow.offer(num);
 * }
 * 
 * maxNumsInWindow = Math.max(maxNumsInWindow, numsInWindow.size());
 * }
 * 
 * return n - maxNumsInWindow;
 * }
 * }
 */
