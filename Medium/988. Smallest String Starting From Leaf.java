class Solution1 {
    private String res;

    public String smallestFromLeaf(TreeNode root) {
        var sb = new StringBuilder();
        sb.append((char) (root.val + 'a'));
        travel(root, sb);
        return res;
    }
    private void travel(TreeNode node, StringBuilder sb) {
        if (node.left == null && node.right == null) {
            var cur = sb.reverse().toString();
            if (res == null || cur.compareTo(res) < 0) {
                res = cur;
            }
            sb.reverse();
        }
        if (node.left != null) {
            sb.append((char) (node.left.val + 'a'));
            travel(node.left, sb);
            sb.setLength(sb.length() - 1);
        }
        if (node.right != null) {
            sb.append((char) (node.right.val + 'a'));
            travel(node.right, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}

class Solution2 {
    private String res;

    public String smallestFromLeaf(TreeNode root) {
        travel(root, new StringBuilder());
        return res;
    }
    private void travel(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append((char) ('a' + node.val));
        if (node.left == null && node.right == null) {
            var cur = sb.reverse().toString();
            if (res == null || cur.compareTo(res) < 0) {
                res = cur;
            }
            sb.reverse();
        }
        travel(node.left, sb);
        travel(node.right, sb);
        sb.setLength(sb.length() - 1);
    }
}