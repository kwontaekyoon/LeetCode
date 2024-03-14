class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int totalCount = 0;
        int sum = 0;
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 1;
        for (int num : nums) {
            sum += num;
            totalCount += sum >= goal ? prefixSum[sum - goal] : 0;
            prefixSum[sum]++;
        }
        return totalCount;
    }
}

class HashTable {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> sumCnt = new HashMap<>();
        sumCnt.put(0, 1);
        int curSum = 0;
        int res = 0;
        for (int num : nums) {
            curSum += num;
            res += sumCnt.getOrDefault(curSum - goal, 0);
            sumCnt.put(curSum, sumCnt.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }
}