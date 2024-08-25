import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        final var res = new ArrayList<Integer>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        dfs(node.left, res);
        dfs(node.right, res);
        res.add(node.val);
    }
}