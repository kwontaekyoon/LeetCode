class Solution {
    public int findDuplicate(int[] nums) {
        // using set -> n space complexity
        // Set<Integer> hs = new HashSet<>();
        // for (int num : nums) {
        // if (!hs.add(num)) {
        // return num;
        // }
        // }
        // return 0;

        // two pointer approach
        // int slow = nums[0];
        // int fast = nums[0];

        // while (true) {
        // slow = nums[slow];
        // fast = nums[nums[fast]];
        // if (slow == fast) {
        // break;
        // }
        // }

        // slow = nums[0];
        // while (slow != fast) {
        // slow = nums[slow];
        // fast = nums[fast];
        // }
        // return slow;

        // binary search
        int low = 1, high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count += 1;
                }
            }
            if (count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}