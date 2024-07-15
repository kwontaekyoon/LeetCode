class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        final var map = new TreeNode[100001];
        final var set = new boolean[100001];
        TreeNode parent = null, child = null;
        for (var desc : descriptions) {
            parent = map[desc[0]] == null ? map[desc[0]] = new TreeNode(desc[0]) : map[desc[0]];
            child = map[desc[1]] == null ? map[desc[1]] = new TreeNode(desc[1]) : map[desc[1]];
            if (desc[2] > 0) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            set[child.val] = true;
        }
        TreeNode root = null;
        for (var desc : descriptions) {
            if (!set[desc[0]]) {
                root = map[desc[0]];
                break;
            }
        }
        return root;
    }
}