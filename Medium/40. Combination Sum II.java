class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int sum) {
        var res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(0, sum, nums, new ArrayList<Integer>(), res);
        return res;
    }

    private void backtrack(int start, int left, int[] nums, List comb, List res) {
        if (left == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > left) {
                break;
            }
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            comb.add(nums[i]);
            backtrack(i + 1, left - nums[i], nums, comb, res);
            comb.removeLast();
        }
    }
}