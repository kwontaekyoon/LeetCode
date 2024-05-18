class Solution {
    private int res = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        int left = dfs(curr.left), right = dfs(curr.right);
        res += Math.abs(left) + Math.abs(right);
        return (curr.val - 1) + left + right;
    }
}