class Solution {
    public int sumNumbers(TreeNode root) {
        return recursion(root, 0);
    }

    private int recursion(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return recursion(node.left, sum) + recursion(node.right, sum);
    }
}