class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 0, lastNum = -101;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != lastNum) {
                lastNum = nums[i];
                nums[cnt] = lastNum;
                cnt += 1;
            }
        }
        return cnt;
    }
}