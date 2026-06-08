class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, pivot);
        int l = 0;
        for (int num : nums) {
            if (num < pivot) {
                res[l++] = num;
            }
        }
        int r = n - 1;
        for (int i = n - 1; i > -1; i--) {
            if (nums[i] > pivot) {
                res[r--] = nums[i];
            }
        }
        return res;
    }
}

class Solution1 {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> bigger = new ArrayList<>();
        int same = 0;
        for (int num : nums) {
            if (num < pivot) {
                smaller.add(num);
            } else if (num > pivot) {
                bigger.add(num);
            } else {
                same++;
            }
        }
        int[] res = new int[nums.length];
        int i = 0;
        for (int num : smaller) {
            res[i++] = num;
        }
        for (int j = 0; j < same; j++) {
            res[i++] = pivot;
        }
        for (int num : bigger) {
            res[i++] = num;
        }
        return res;
    }
}
