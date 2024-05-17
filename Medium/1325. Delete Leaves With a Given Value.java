class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        var dummy = new TreeNode(0, null, root);
        dfs(dummy, root, target);
        return dummy.right;
    }

    private void dfs(TreeNode prev, TreeNode curr, int target) {
        if (curr == null) {
            return;
        }
        dfs(curr, curr.left, target);
        dfs(curr, curr.right, target);
        if (curr.left == null && curr.right == null && curr.val == target) {
            if (curr.equals(prev.left)) {
                prev.left = null;
            } else {
                prev.right = null;
            }
        }
    }
}}

class Solution1 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        var l = removeLeafNodes(root.left, target);
        var r = removeLeafNodes(root.right, target);
        if (l == null && r == null && root.val == target) {
            return null;
        }
        root.left = l;
        root.right = r;
        return root;
    }
}