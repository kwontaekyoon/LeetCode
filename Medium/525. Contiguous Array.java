class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> diffToIndex = new HashMap<>();
        diffToIndex.put(0, -1);
        int maxLength = 0;
        for (int i = 0, diff = 0; i < n; i++) {
            diff += nums[i] == 0 ? -1 : 1;
            if (diffToIndex.containsKey(diff)) {
                maxLength = Math.max(i - diffToIndex.get(diff), maxLength);
            } else {
                diffToIndex.put(diff, i);
            }  
        }
        return maxLength;
    }
}