import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> postorder(Node root) {
        final var res = new ArrayList<Integer>();
        dfs(root, res);
        return res;
    }

    private void dfs(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        for (var child : node.children) {
            dfs(child, res);
        }
        res.add(node.val);
    }
}