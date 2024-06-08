class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        final int N = nums.length;
        for (int i = 1; i < N; i++) {
            nums[i] += nums[i - 1];
            if (nums[i] % k == 0) {
                return true;
            }
        }
        final var set = new HashSet<Integer>();
        for (int i = 2; i < N; i++) {
            set.add(nums[i - 2] % k);
            if (set.contains(nums[i] % k)) {
                return true;
            }
        }
        return false;
    }
}

class Solution1 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        final var set = new HashSet<Integer>();
        final int N = nums.length;
        int prev = nums[0], curr = nums[0] + nums[1];
        set.add(prev);
        if (curr % k == 0) {
            return true;
        }
        for (int i = 2; i < N; i++) {
            prev = curr;
            curr += nums[i];
            if (curr % k == 0) {
                return true;
            }
            for (int kMul = curr / k * k; kMul >= 0; kMul -= k) {
                if (set.contains(curr - kMul)) {
                    return true;
                }
            }
            set.add(prev);
        }
        return false;
    }
}