class Solution {
    private List<List<Integer>> combinations = new ArrayList<>();

    private void makeCombs(List<Integer> comb, int[] nums, int target, int idx) {
        if (target == 0) {
            combinations.add(new ArrayList<>(comb));
        } else {
            for (int i = idx; i < nums.length; i++) {
                if (target - nums[i] >= 0) {
                    comb.add(nums[i]);
                    makeCombs(comb, nums, target - nums[i], i);
                    comb.remove(comb.size() - 1);
                }
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        makeCombs(new ArrayList<>(), candidates, target, 0);
        return combinations;
    }
}