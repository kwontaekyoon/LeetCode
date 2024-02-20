class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] check = new int[n + 1];
        for (int i = 0; i < n; i++) {
            check[nums[i]] = 1;
        }
        for (int i = 0; i <= n; i++) {
            if (check[i] == 0) {
                return i;
            }
        }
        return n;
    }
}