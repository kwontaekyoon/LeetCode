class Solution {
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