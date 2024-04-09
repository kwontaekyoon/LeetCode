class Solution {
    public int subarraySum(int[] nums, int k) {
        var prefixToCount = new HashMap<Integer, Integer>();
        prefixToCount.put(0, 1);
        int sum = 0, cnt = 0;
        for (int num : nums) {
            sum += num;
            cnt += prefixToCount.getOrDefault(sum - k, 0);
            prefixToCount.put(sum, prefixToCount.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}