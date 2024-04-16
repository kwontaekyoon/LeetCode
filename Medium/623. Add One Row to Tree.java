class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        var dummy = new TreeNode(0, root, null);
        var res = dummy;
        var queue = new ArrayDeque<TreeNode>();
        queue.offerLast(dummy);
        while (queue.size() > 0) {
            depth--;
            if (depth > 0) {
                for (int i = queue.size(); i > 0; i--) {
                    var curr = queue.pollFirst();
                    if (curr.left != null) {
                        queue.offerLast(curr.left);
                    }
                    if (curr.right != null) {
                        queue.offerLast(curr.right);
                    }
                }
            } else {
                for (int i = queue.size(); i > 0; i--) {
                    var curr = queue.pollFirst();
                    var left = curr.left;
                    var righ = curr.right;
                    curr.left = new TreeNode(val, left, null);
                    curr.right = new TreeNode(val, null, righ);
                }
                break;
            }
        }
        return res.left;
    }
}