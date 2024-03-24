class BinarySearch {
    public int findDuplicate(int[] nums) {
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

class TwoPointers {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
