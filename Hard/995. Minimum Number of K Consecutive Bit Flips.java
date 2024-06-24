class Solution {
    public int minKBitFlips(int[] nums, int k) {
        final int n = nums.length;
        int flipped = 0, res = 0;
        final var isFlipped = new int[n];

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flipped ^= isFlipped[i - k];
            }
            if (flipped != nums[i]) {
                continue;
            }
            if (i > n - k) {
                return -1;
            }
            isFlipped[i] = 1;
            flipped ^= 1;
            res++;
        }

        return res;
    }
}

class TLE {
    public int minKBitFlips(int[] nums, int k) {
        final int N = nums.length;
        int flipCnt = 0;
        for (int i = 0; i < N; i++) {
            if (nums[i] == 1) {
                continue;
            }
            if (N - i < k) {
                return -1;
            }
            flip(nums, i, k);
            flipCnt++;
        }
        return flipCnt;
    }

    private void flip(int[] nums, int start, int k) {
        for (int i = start; i < start + k; i++) {
            nums[i] = nums[i] == 1 ? 0 : 1;
        }
    }
}