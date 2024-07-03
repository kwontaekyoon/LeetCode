class Greedy {
    public int minDifference(int[] nums) {
        final int n = nums.length;
        if (n < 5) {
            return 0;
        }
        for (int i = 0; i < 4; i++) {
            if (i > n / 2) {
                break;
            }
            moveMinToIndex(nums, n, i);
            moveMaxToIndex(nums, n, i);
        }
        int res = Integer.MAX_VALUE;
        for (int l = 0; l < 4; l++) {
            int r = n - 1 - (3 - l);
            res = Math.min(res, nums[r] - nums[l]);
        }
        return res;
    }

    private void moveMinToIndex(int[] nums, int n, int index) {
        int minIndex = index;
        for (int i = index; i < n - index; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }
        int tmp = nums[minIndex];
        nums[minIndex] = nums[index];
        nums[index] = tmp;
    }

    private void moveMaxToIndex(int[] nums, int n, int index) {
        int maxIndex = index;
        for (int i = index; i < n - index; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        int tmp = nums[maxIndex];
        nums[maxIndex] = nums[n - 1 - index];
        nums[n - 1 - index] = tmp;
    }
}

class Sorting {
    public int minDifference(int[] nums) {
        final int n = nums.length;
        if (n <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int l = 0; l <= 3; l++) {
            int r = n - 1 - (3 - l);
            res = Math.min(res, nums[r] - nums[l]);
        }
        return res;
    }
}