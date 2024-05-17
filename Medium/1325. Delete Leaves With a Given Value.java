class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        var dummy = new TreeNode(0, null, root);
        dfs(dummy, root, target, true);
        return dummy.right;
    }

    private void dfs(TreeNode prev, TreeNode curr, int target, boolean right) {
        if (curr == null) {
            return;
        }
        dfs(curr, curr.left, target, false);
        dfs(curr, curr.right, target, true);
        if (curr.left == null && curr.right == null && curr.val == target) {
            if (right) {
                prev.right = null;
            } else {
                prev.left = null;
            }
        }
    }
}

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