// Sliding Window
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int k = 0;
        for (int i = 0; i < n; i++) {
            k += nums[i];
        }
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            cnt += nums[i];
        }
        int mx = cnt;
        for (int i = k; i < n + k; i++) {
            cnt += (nums[i % n] - nums[(i - k + n) % n]);
            mx = Math.max(mx, cnt);
        }
        return k - mx;
    }
}

// failed
class Solution1 {
    public int minSwaps(int[] nums) {
        final int n = nums.length;
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            totalOnes += nums[i];
        }
        if (totalOnes <= 1) {
            return 0;
        }
        int swaps = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int zeros = 0, ones = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zeros++;
                } else {
                    ones++;
                    if (ones == totalOnes) {
                        swaps = Math.min(swaps, zeros + ones - totalOnes);
                    }
                }
            }
            for (int j = 0; j < i; j++) {
                if (nums[j] == 0) {
                    zeros++;
                } else {
                    ones++;
                    if (ones == totalOnes) {
                        swaps = Math.min(swaps, zeros + ones - totalOnes);
                    }
                }
            }
        }
        return swaps;
    }
}