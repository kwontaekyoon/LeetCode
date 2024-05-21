class Solution {
    final List<List<Integer>> res = new ArrayList<>();
    final List<Integer> sub = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        final int N = nums.length;
        Arrays.sort(nums);
        dfs(nums, N, 0);
        return res;
    }

    private void dfs(int[] nums, int N, int index) {
        res.add(new ArrayList(sub));
        // final var set = new HashSet<Integer>();
        for (int i = index; i < N; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            // if (set.add(nums[i])) {
            sub.add(nums[i]);
            dfs(nums, N, i + 1);
            sub.removeLast();
            // }
        }
    }
}