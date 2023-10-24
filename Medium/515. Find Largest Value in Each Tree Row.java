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
    private void dfs(TreeNode root, List<Integer> largests, int depth) {
        if (root == null) {
            return;
        }
        if (largests.size() <= depth) {
            largests.add(root.val);
        } else if (largests.get(depth) < root.val) {
            largests.set(depth, root.val);
        }
        dfs(root.left, largests, depth + 1);
        dfs(root.right, largests, depth + 1);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        dfs(root, al, 0);
        return al;
    }
}

// class Solution {
// public List<Integer> largestValues(TreeNode root) {
// List<Integer> al = new ArrayList<>();
// if (root == null) {
// return al;
// }
// Deque<TreeNode> q = new ArrayDeque<>();
// q.offerLast(root);
// while (!q.isEmpty()) {
// int size = q.size();
// int largest = Integer.MIN_VALUE;
// for (int i = 0; i < size; i++) {
// TreeNode node = q.pollFirst();
// largest = Math.max(largest, node.val);
// if (node.left != null) {
// q.offerLast(node.left);
// }
// if (node.right != null) {
// q.offerLast(node.right);
// }
// }
// al.add(largest);
// }
// return al;
// }
// }