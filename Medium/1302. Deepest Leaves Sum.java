/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        Queue<TreeNode> tmp = new LinkedList<>();
        int sum = 0, currSize = 0;
        que.offer(root);
        while (que.size() != 0) {
            currSize = que.size();
            for (TreeNode node : que) {
                if (node.left != null) {
                    tmp.offer(node.left);
                }
                if (node.right != null) {
                    tmp.offer(node.right);
                }
            }
            if (tmp.size() != 0) {
                while (!que.isEmpty()) {
                    que.poll();
                }
                while (!tmp.isEmpty()) {
                    que.offer(tmp.poll());
                }
            } else {
                while (!que.isEmpty()) {
                    sum += que.poll().val;
                }
            }
        }
        return sum;
    }
}