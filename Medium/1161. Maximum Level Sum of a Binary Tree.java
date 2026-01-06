import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxLevel = 0;
        int startLevel = 0;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            startLevel++;
            int nodes = queue.size();
            int sum = 0;
            for (int i = 0; i < nodes; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (maxSum < sum) {
                maxSum = sum;
                maxLevel = startLevel;
            }
        }
        return maxLevel;
    }
}