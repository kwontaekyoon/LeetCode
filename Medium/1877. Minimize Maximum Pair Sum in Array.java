class Solution {
    public int minPairSum(int[] nums) {
        int[] freq = new int[100001];
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;

        for (int num : nums) {
            freq[num]++;
            maxNum = Math.max(num, maxNum);
            minNum = Math.min(num, minNum);
        }

        int maxPairSum = Integer.MIN_VALUE;

        while (minNum <= maxNum) {
            if (freq[maxNum] == 0) {
                maxNum--;
            } else if (freq[minNum] == 0) {
                minNum++;
            } else {
                maxPairSum = Math.max(minNum + maxNum, maxPairSum);
                freq[minNum]--;
                freq[maxNum]--;
            }
        }

        return maxPairSum;
    }
}

// greedy array
// class Solution {
// public int minPairSum(int[] nums) {
// Arrays.sort(nums);
// int len = nums.length;
// int maxSum = Integer.MIN_VALUE;
// for (int i = 0; i < len / 2; i++) {
// maxSum = Math.max(nums[i] + nums[len - 1 - i], maxSum);
// }
// return maxSum;
// }
// }
// the bigger the value is the smaller the matching value