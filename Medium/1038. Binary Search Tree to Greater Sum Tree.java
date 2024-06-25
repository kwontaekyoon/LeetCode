class Recursion {
    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);
        }

        return root;
    }
}

class Solution {
    public TreeNode bstToGst(TreeNode root) {
        if (root == null)
            return root;
        List<TreeNode> list = new ArrayList<>();
        traversal(root, list);
        int sum = 0;
        for (TreeNode x : list) {
            sum = sum + x.val;
            x.val = sum;
        }
        return root;
    }

    public void traversal(TreeNode root, List<TreeNode> list) {
        if (root.right != null)
            traversal(root.right, list);
        list.add(root);
        if (root.left != null)
            traversal(root.left, list);
    }
}