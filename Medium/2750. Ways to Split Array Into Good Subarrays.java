class Solution {
    private final static int MOD = (int) 1e9 + 7;
    public int numberOfGoodSubarraySplits(int[] nums) {
        int n = nums.length;
        int one = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                one = i;
                break;
            }
        }
        if (one == -1) {
            return 0;
        }
        long res = 1;
        for (int i = one + 1; i < n; i++) {
            if (nums[i] == 1){
                res = (res * (i - one)) % MOD;
                one = i;
            }
        }
        return (int) res;
    }
}