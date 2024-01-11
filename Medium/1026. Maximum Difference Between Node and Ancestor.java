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
class Solution1 {
    private int maxDiff = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        travel(root, new int[] { root.val, root.val });
        return maxDiff;
    }

    private void travel(TreeNode decendent, int[] minAndMax) {
        if (decendent == null) {
            return;
        }
        int[] tmp = new int[2];
        for (int i = 0; i < 2; i++) {
            maxDiff = Math.max(Math.abs(minAndMax[i] - decendent.val), maxDiff);
            tmp[i] = minAndMax[i];
        }
        minAndMax[0] = Math.min(decendent.val, minAndMax[0]);
        minAndMax[1] = Math.max(decendent.val, minAndMax[1]);
        travel(decendent.left, minAndMax);
        travel(decendent.right, minAndMax);
        minAndMax[0] = tmp[0];
        minAndMax[1] = tmp[1];
    }
}

class Solution2 {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode cur, int curMin, int curMax) {
        if (cur == null) {
            return curMax - curMin;
        }
        curMin = Math.min(curMin, cur.val);
        curMax = Math.max(curMax, cur.val);
        int left = dfs(cur.left, curMin, curMax);
        int right = dfs(cur.right, curMin, curMax);
        return Math.max(left, right);
    }
}