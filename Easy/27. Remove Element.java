class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length, found = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[found] = nums[i];
                found++;
            }
        }
        return found;
    }
}