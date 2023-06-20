class Solution {
    public int[] getAverages(int[] nums, int k) {
        long sum = 0L;
        int len = nums.length;
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            if (i - k >= 0 && i + k < len) {
                if (sum == 0) {
                    for (int j = 0; j < 2 * k + 1; j++) {
                        sum += nums[j];
                    }
                } else {
                    sum += nums[i + k];
                    sum -= nums[i - k - 1];
                }
                answer[i] = (int) (sum / (2 * k + 1));
            } else {
                answer[i] = -1;
            }
        }
        return answer;
    }
}