/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {
        mapping(root);
        int time = -1;
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                visited.add(cur);
                if (map.containsKey(cur)) {
                    for (int route : map.get(cur)) {
                        if (!visited.contains(route)) {
                            queue.offer(route);
                        }
                    }
                }
            }
            time++;
        }
        return time;
    }

    private void mapping(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            map.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.left.val);
            map.computeIfAbsent(node.left.val, k -> new ArrayList<>()).add(node.val);
        }
        if (node.right != null) {
            map.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.right.val);
            map.computeIfAbsent(node.right.val, k -> new ArrayList<>()).add(node.val);
        }
        mapping(node.left);
        mapping(node.right);
    }
}