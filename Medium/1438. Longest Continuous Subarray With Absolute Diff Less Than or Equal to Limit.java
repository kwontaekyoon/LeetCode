class Solution {
    public int longestSubarray(int[] nums, int limit) {
        final int N = nums.length;
        final var increase = new LinkedList<Integer>();
        final var decrease = new LinkedList<Integer>();
        int res = 0;
        for (int l = 0, r = 0; r < N; r++) {
            while (!increase.isEmpty() && nums[r] < increase.getLast()) {
                increase.removeLast();
            }
            increase.add(nums[r]);
            while (!decrease.isEmpty() && nums[r] > decrease.getLast()) {
                decrease.removeLast();
            }
            decrease.add(nums[r]);

            while (decrease.getFirst() - increase.getFirst() > limit) {
                if (nums[l] == decrease.getFirst()) {
                    decrease.removeFirst();
                }
                if (nums[l] == increase.getFirst()) {
                    increase.removeFirst();
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

class Solution1 {
    public int longestSubarray(int[] nums, int limit) {
        final int N = nums.length;
        int currMin = nums[0], currMax = nums[0];
        int l = 0, r = 0, res = 0;
        while (r < N) {
            while (r < N && Math
                    .abs((currMin = Math.min(currMin, nums[r])) - (currMax = Math.max(currMax, nums[r]))) <= limit) {
                res = Math.max(res, r - l + 1);
                r++;
            }
            while (l < N - 1 && nums[l] == nums[l + 1]) {
                l++;
            }
            l++;
            r = l;
            if (r < N) {
                currMin = nums[r];
                currMax = nums[r];
            }
        }
        return res;
    }
}