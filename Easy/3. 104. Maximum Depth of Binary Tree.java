class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxL = maxDepth(root.left);
        int maxR = maxDepth(root.right);
        return Math.max(maxL, maxR) + 1;
    }
}