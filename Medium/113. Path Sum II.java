class Solution1 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        final var res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        final var path = new ArrayList<Integer>();
        path.add(root.val);
        dfs(root, root.val, targetSum, path, res);
        return res;
    }

    private void dfs(
            TreeNode curr, int currSum, int targetSum,
            List<Integer> path, List<List<Integer>> res) {
        if (currSum == targetSum && curr.left == null && curr.right == null) {
            res.add(new ArrayList(path));
            return;
        }
        if (curr.left != null) {
            path.add(curr.left.val);
            dfs(curr.left, currSum + curr.left.val, targetSum, path, res);
            path.removeLast();
        }
        if (curr.right != null) {
            path.add(curr.right.val);
            dfs(curr.right, currSum + curr.right.val, targetSum, path, res);
            path.removeLast();
        }
    }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        final var res = new ArrayList<List<Integer>>();
        dfs(root, targetSum, res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(TreeNode curr, int targetSum, List<List<Integer>> res, List<Integer> path) {
        if (curr == null) {
            return;
        }
        if (curr.left == null && curr.right == null && curr.val == targetSum) {
            path.add(curr.val);
            res.add(new ArrayList(path));
            path.removeLast();
            return;
        }
        path.add(curr.val);
        dfs(curr.left, targetSum - curr.val, res, path);
        dfs(curr.right, targetSum - curr.val, res, path);
        path.removeLast();
    }
}