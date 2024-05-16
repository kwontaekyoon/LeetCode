class Solution {
    public boolean evaluateTree(TreeNode root) {
        switch (root.val) {
            default:
                return root.val == 1;
            case 2:
                return evaluateTree(root.left) || evaluateTree(root.right);
            case 3:
                return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}