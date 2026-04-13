class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int dist = Integer.MAX_VALUE;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == target) {
                dist = Math.min(Math.abs(i - start), dist);
            }
            i++;
        }
        return dist;
    }
}
