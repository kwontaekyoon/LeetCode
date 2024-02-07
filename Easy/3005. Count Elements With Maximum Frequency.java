class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freqs = new int[101];
        int maxFreq = 0;
        for (int num : nums) {
            freqs[num]++;
            maxFreq = Math.max(maxFreq, freqs[num]);
        }
        int cnt = 0;
        for (int freq : freqs) {
            if (freq == maxFreq) {
                cnt += maxFreq;
            }
        }
        return cnt;
    }
}