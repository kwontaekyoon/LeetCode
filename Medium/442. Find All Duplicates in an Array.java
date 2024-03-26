class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        var dups = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]);
            if (nums[idx - 1] < 0) {
                dups.add(idx);
            } else {
                nums[idx - 1] *= -1;
            }
        }
        return dups;
    }
}

class Sorting {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                int num = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = num;
            }
        }
        var dups = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                dups.add(nums[i]);
            }
        }
        return dups;
    }
}
