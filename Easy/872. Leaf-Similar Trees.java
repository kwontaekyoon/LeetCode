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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> firstLeafs = new ArrayList<>();
        List<Integer> secondLeafs = new ArrayList<>();
        travel(root1, firstLeafs);
        travel(root2, secondLeafs);
        return firstLeafs.equals(secondLeafs);
    }

    private void travel(TreeNode root, List<Integer> leafs) {
        if (root.left == null && root.right == null) {
            leafs.add(root.val);
        } else {
            if (root.left != null) {
                travel(root.left, leafs);
            }
            if (root.right != null) {
                travel(root.right, leafs);
            }
        }
    }
}