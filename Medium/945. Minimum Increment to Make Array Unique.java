class Sorting {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                res += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return res;
    }
}

class Counting {
    public int minIncrementForUnique(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        final var freqs = new int[max + nums.length];
        for (int num : nums) {
            freqs[num]++;
        }
        int ans = 0;
        for (int i = 0; i < max + nums.length; i++) {
            if (freqs[i] <= 1) {
                continue;
            }
            freqs[i + 1] += freqs[i] - 1;
            ans += freqs[i] - 1;
        }
        return ans;
    }
}