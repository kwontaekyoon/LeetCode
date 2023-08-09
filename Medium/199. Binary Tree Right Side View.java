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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        if (root == null)
            return al;
        dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            al.add(dq.getLast().val);
            for (int i = 0; i < size; i++) {
                TreeNode node = dq.poll();
                if (node.left != null)
                    dq.offer(node.left);
                if (node.right != null)
                    dq.offer(node.right);
            }
        }
        return al;
    }
}