class Solution {
    int maxDepth = -1;
    int leftVal = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return leftVal;
    }
    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level > maxDepth) {
            maxDepth = level;
            leftVal = node.val;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}

class usingList {
    private List<List<Integer>> nodesByLevel;
    public int findBottomLeftValue(TreeNode root) {
        nodesByLevel = new ArrayList<>();
        dfs(root, 0);
        return nodesByLevel.get(nodesByLevel.size() - 1).get(0);
    }
    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (nodesByLevel.size() == level) {
            nodesByLevel.add(new ArrayList<>());
        }
        nodesByLevel.get(level).add(node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}