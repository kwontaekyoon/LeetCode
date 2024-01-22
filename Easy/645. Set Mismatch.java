class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] freqs = new int[n + 1];
        for (int i = 0; i < n; i++) {
            freqs[nums[i]]++;
        }
        int[] errs = new int[2];
        for (int i = 1; i <= n; i++) {
            if (freqs[i] == 0) {
                errs[1] = i;
            } else if (freqs[i] == 2) {
                errs[0] = i;
            }
        }
        return errs;
    }
}