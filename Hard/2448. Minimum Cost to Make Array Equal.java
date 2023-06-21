class Solution {
    public long getCost(int[] nums, int[] costs, int value) {
        long cost = 0L;
        for (int idx = 0; idx < nums.length; idx++) {
            cost += ((long) Math.abs(value - nums[idx]) * (long) costs[idx]);
        }
        return cost;
    }

    public long minCost(int[] nums, int[] costs) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }
        long answer = Math.min(getCost(nums, costs, minValue), getCost(nums, costs, maxValue));
        while (minValue < maxValue) {
            int midValue = minValue + (maxValue - minValue) / 2;
            long costL = getCost(nums, costs, midValue);
            long costR = getCost(nums, costs, midValue + 1);
            if (costL < costR) {
                answer = costL;
                maxValue = midValue;
            } else {
                answer = costR;
                minValue = midValue + 1;
            }
        }
        return answer;
    }
}