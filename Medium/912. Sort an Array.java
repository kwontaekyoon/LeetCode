class Solution {
    public int[] sortArray(int[] nums) {
        final var cnt = new int[100001];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int x = 0;
        for (int num : nums) {
            x = num + 50000;
            cnt[x]++;
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        int y = 0;
        for (int i = min; i <= max; i++) {
            while (cnt[i]-- > 0) {
                nums[y++] = i - 50000;
            }
        }
        return nums;
    }
}

class Solution1 {
    public int[] sortArray(int[] nums) {
        final int n = nums.length;
        int upperBound = Integer.MIN_VALUE;
        int lowerBound = Integer.MAX_VALUE;
        for (int num : nums) {
            upperBound = Math.max(upperBound, num);
            lowerBound = Math.min(lowerBound, num);
        }
        final var minusCnt = new int[lowerBound > 0 ? 0 : -lowerBound + 1];
        final var plusCnt = new int[upperBound < 0 ? 0 : upperBound + 1];
        for (int num : nums) {
            if (num < 0) {
                minusCnt[-num]++;
            } else {
                plusCnt[num]++;
            }
        }
        int i = 0;
        for (int m = -lowerBound; m > 0; m--) {
            while (minusCnt[m] > 0) {
                nums[i++] = -m;
                minusCnt[m]--;
            }
        }
        for (int p = 0; p <= upperBound; p++) {
            while (plusCnt[p] > 0) {
                nums[i++] = p;
                plusCnt[p]--;
            }
        }
        return nums;
    }
}