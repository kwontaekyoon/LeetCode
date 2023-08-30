class Solution {
    public long minimumReplacement(int[] nums) {
        long replaces = 0L;
        for (int i = nums.length - 2; i >= 0; i--) { // non-increasing
            if (nums[i] > nums[i + 1]) {
                if (nums[i] % nums[i + 1] == 0) {
                    replaces += (nums[i] / nums[i + 1] - 1);
                    nums[i] = nums[i + 1];
                } else {
                    for (int part = 2; part <= nums[i]; part++) {
                        int d = nums[i] / part;
                        int r = nums[i] % part;
                        if ((r > 0 && d + 1 <= nums[i + 1]) || (r == 0 && d <= nums[i + 1])) {
                            replaces += (part - 1);
                            nums[i] = d;
                            break;
                        }
                    }
                }
            }
        }
        return replaces;
    }
}