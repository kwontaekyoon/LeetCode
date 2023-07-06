class Solution {
    public int thirdMax(int[] nums) {
        long maxNow = Long.MAX_VALUE;
        long maxNum = 0L;
        for (int iter = 0; iter < 3; iter++) {
            long tmp = Long.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < maxNow && nums[i] > tmp) {
                    tmp = nums[i];
                }
            }
            if (iter == 0) {
                maxNum = tmp;
            }
            maxNow = tmp;
        }
        return maxNow != Long.MIN_VALUE ? (int) maxNow : (int) maxNum;
    }
}