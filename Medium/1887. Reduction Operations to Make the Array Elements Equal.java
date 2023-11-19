class Solution {
    public int reductionOperations(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        int[] freq = new int[50001];

        for (int num : nums) {
            minNum = Math.min(num, minNum);
            maxNum = Math.max(num, maxNum);
            freq[num]++;
        }

        int cnt = 0, ops = 0;

        for (int i = maxNum; i > minNum; i--) {
            if (freq[i] == 0) {
                continue;
            }
            cnt += freq[i];
            ops += cnt;
        }

        return ops;
    }
}