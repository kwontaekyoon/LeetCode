/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> output = new ArrayList<>();
        int[][] graph = new int[501][501];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    graph[currentNode.val][currentNode.left.val] = 1;
                    graph[currentNode.left.val][currentNode.val] = 1;
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    graph[currentNode.val][currentNode.right.val] = 1;
                    graph[currentNode.right.val][currentNode.val] = 1;
                    queue.offer(currentNode.right);
                }
            }
        }
        Queue<Integer> queue2 = new LinkedList<>();
        boolean[][] visited = new boolean[501][501];
        queue2.add(target.val);
        for (int iter = 0; iter < k; iter++) {
            int size = queue2.size();
            for (int i = 0; i < size; i++) {
                int current = queue2.remove();
                for (int j = 0; j < 501; j++) {
                    if (graph[current][j] == 1 && !visited[current][j] && j != target.val && !visited[j][current]) {
                        visited[current][j] = true;
                        visited[j][current] = true;
                        queue2.add(j);
                    }
                }
            }
        }
        output.addAll(queue2);
        return output;
    }
}