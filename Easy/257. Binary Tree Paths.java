class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        var res = new ArrayList<String>();
        travel(root, new StringBuilder(), res);
        return res;
    }
    private void travel(TreeNode node, StringBuilder path, List res) {
        if (node == null) {
            return;
        }
        int size = path.length();
        if (size > 0) {
            path.append("->");
        }
        path.append(node.val);
        if (node.left == null && node.right == null) {
            res.add(path.toString());
        }
        travel(node.left, path, res);
        travel(node.right, path, res);
        path.setLength(size);
    }
}