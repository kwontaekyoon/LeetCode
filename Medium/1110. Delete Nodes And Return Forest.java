class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        final var res = new ArrayList<TreeNode>();
        final var set = new int[1001];
        for (var delete : to_delete) {
            set[delete] = 1;
        }
        var dummy = new TreeNode(0, null, root);
        dfs(dummy, root, res, set, true, true);
        return res;
    }

    private void dfs(TreeNode prev, TreeNode curr, List<TreeNode> res, int[] set, boolean right,
            boolean fatherDeleted) {
        if (curr == null) {
            return;
        }
        if (set[curr.val] > 0) {
            if (right) {
                prev.right = null;
            } else {
                prev.left = null;
            }
            dfs(curr, curr.left, res, set, false, true);
            dfs(curr, curr.right, res, set, true, true);
        } else {
            if (fatherDeleted) {
                res.add(curr);
            }
            dfs(curr, curr.left, res, set, false, false);
            dfs(curr, curr.right, res, set, true, false);
        }
    }
}