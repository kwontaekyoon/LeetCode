class Solution {
    private int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findDepth(root);
        return maxDiameter;
    }
    private int findDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = findDepth(node.left);
        int right = findDepth(node.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    }
}