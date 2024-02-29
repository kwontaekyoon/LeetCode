class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int currLevel = 0;
        queue.offer(root);
        while (queue.size() > 0) {
            int lastElement = currLevel % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode curr = queue.poll();
                if (currLevel % 2 == 0) { // odd and increase
                    if (curr.val % 2 == 0 || curr.val <= lastElement) {
                        return false;
                    }
                } else { // even and decrease
                    if (curr.val % 2 != 0 || curr.val >= lastElement) {
                        return false;
                    }
                }
                lastElement = curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            currLevel++;
        }
        return true;
    }
}