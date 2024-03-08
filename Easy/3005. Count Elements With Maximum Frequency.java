class Solution {
    public int maxFrequencyElements(int[] nums) {
        int high = -1, low = 101;
        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }
        int[] freqs = new int[high - low + 1];
        int maxFreq = -1;
        for (int num : nums) {
            maxFreq = Math.max(maxFreq, ++freqs[num - low]);
        }
        int res = 0;
        for (int freq : freqs) {
            if (freq == maxFreq) {
                res += maxFreq;
            }
        }
        return res;
    }
}