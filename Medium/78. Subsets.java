class Solution {
    private void backtrack(int[] nums, int idx, List<Integer> subset, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(subset));
        for (int i = idx; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, subsets);
            subset.remove(subset.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }
}

class Solution1 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList(curr));
            return;
        }
        dfs(nums, index + 1);
        curr.add(nums[index]);
        dfs(nums, index + 1);
        curr.removeLast();
    }
}

class Iteration {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // Add the empty subset
        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(num);
                result.add(subset);
            }
        }
        return result;
    }
}