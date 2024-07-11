import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        final var n = nums.length;
        final var res = new ArrayList<List<Integer>>();
        final var use = new boolean[n];
        dfs(nums, n, use, res, new HashSet<Integer>(), new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] nums, int n, boolean[] use, List<List<Integer>> res, Set<Integer> set, List<Integer> perm) {
        if (n == 0) {
            res.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (use[i] || set.contains(nums[i])) {
                continue;
            }
            use[i] = true;
            perm.add(nums[i]);
            set.add(nums[i]);
            dfs(nums, n - 1, use, res, new HashSet<Integer>(), perm);
            use[i] = false;
            perm.remove(perm.size() - 1);
        }
    }
}