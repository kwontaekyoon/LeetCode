/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int numOfPalindromicPaths = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freqs = new int[10];
        freqs[root.val]++;
        travel(root, freqs);
        return numOfPalindromicPaths;
    }
    private void travel(TreeNode node, int[] freqs) {
        if (node.left == null && node.right == null) {
            if (isPalindromic(freqs)) {
                numOfPalindromicPaths++;
            }
        }
        if (node.left != null) {
            freqs[node.left.val]++;
            travel(node.left, freqs);
            freqs[node.left.val]--;
        }
        if (node.right != null) {
            freqs[node.right.val]++;
            travel(node.right, freqs);
            freqs[node.right.val]--;
        }
    }
    private boolean isPalindromic(int[] freqs) {
        int odds = 0;
        for (int i = 1; i < 10; i++) {
            if (freqs[i] % 2 == 1) {
                odds++;
            }
        }
        return (odds == 1) || (odds == 0);
    }
}