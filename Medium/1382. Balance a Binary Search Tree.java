class Solution1 {
    public TreeNode balanceBST(TreeNode root) {
        final var nodes = new ArrayList<TreeNode>();
        dfs(root, nodes);
        final int n = nodes.size();
        var newRoot = nodes.get(n / 2);
        newRoot.left = null;
        newRoot.right = null;
        var dummy1 = newRoot;
        for (int i = n / 2 - 1; i >= 0; i--) {
            dummy1.left = nodes.get(i);
            dummy1 = dummy1.left;
            dummy1.right = null;
        }
        dummy1.left = null;
        var dummy2 = newRoot;
        for (int i = n / 2 + 1; i < n; i++) {
            dummy2.right = nodes.get(i);
            dummy2 = dummy2.right;
            dummy2.left = null;
        }
        dummy2.right = null;
        return newRoot;
    }

    private void dfs(TreeNode node, List<TreeNode> nodes) {
        if (node == null) {
            return;
        }
        dfs(node.left, nodes);
        nodes.add(node);
        dfs(node.right, nodes);
    }
}

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        final var nodes = new ArrayList<TreeNode>();
        dfs(root, nodes);
        return buildBalancedBST(nodes, 0, nodes.size() - 1);
    }

    private TreeNode buildBalancedBST(List<TreeNode> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = nodes.get(mid);
        node.left = buildBalancedBST(nodes, start, mid - 1);
        node.right = buildBalancedBST(nodes, mid + 1, end);
        return node;
    }

    private void dfs(TreeNode node, List<TreeNode> nodes) {
        if (node == null) {
            return;
        }
        dfs(node.left, nodes);
        nodes.add(node);
        dfs(node.right, nodes);
    }
}