class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        final int N = nums.length;
        final var bucket = new int[32];
        int prefix = 0;
        int minLen = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < N; r++) {
            int temp = nums[r];
            int idx = 0;
            while (temp > 0) {
                bucket[idx++] += temp % 2;
                temp /= 2;
            }
            prefix |= nums[r];
            if (prefix < k) {
                continue;
            }
            while (l < r && prefix >= k) {
                idx = 0;
                while (nums[l] > 0) {
                    if (nums[l] % 2 == 1) {
                        bucket[idx] -= 1;
                        if (bucket[idx] == 0) {
                            prefix ^= (1 << idx);
                        }
                    }
                    nums[l] /= 2;
                    idx++;
                }
                l++;
            }
            if (prefix >= k) {
                minLen = Math.min(minLen, r - l + 1);
            } else {
                minLen = Math.min(minLen, r - l + 2);
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}

class BruteForce {
    public int minimumSubarrayLength(int[] nums, int k) {
        final int N = nums.length;
        int prefix = 0;
        int minLen = -1;
        for (int i = 0; i < N; i++) {
            prefix |= nums[i];
            if (prefix < k) {
                continue;
            }
            int curPrefix = 0;
            int j = i;
            while (j > -1 && curPrefix < k) {
                curPrefix |= nums[j--];
            }
            if (minLen == -1) {
                minLen = Math.max(i - j, 1);
            } else {
                minLen = Math.min(minLen, Math.max(i - j, 1));
            }
        }
        return minLen;
    }
}