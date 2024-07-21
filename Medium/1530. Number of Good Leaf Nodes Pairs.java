import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private int res = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }

    private int[] dfs(TreeNode node, int distance) {
        if (node == null) {
            return new int[distance + 1];
        }
        if (node.left == null && node.right == null) {
            final var leafDistance = new int[distance + 1];
            leafDistance[1] = 1;
            return leafDistance;
        }

        final var left = dfs(node.left, distance);
        final var right = dfs(node.right, distance);

        // calculate result
        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance - i; j++) {
                res += left[i] * right[j];
            }
        }

        final var leafDistance = new int[distance + 1];
        for (int i = 1; i < distance; i++) {
            leafDistance[i + 1] = left[i] + right[i];
        }
        return leafDistance;
    }
}

class Solution1 {
    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> leaves = new ArrayList<>();
        findLeaves(root, new ArrayList<>(), leaves, map);
        int res = 0;
        for (int i = 0; i < leaves.size(); i++) {
            for (int j = i + 1; j < leaves.size(); j++) {
                List<TreeNode> list_i = map.get(leaves.get(i));
                List<TreeNode> list_j = map.get(leaves.get(j));
                for (int k = 0; k < Math.min(list_i.size(), list_j.size()); k++) {
                    if (list_i.get(k) != list_j.get(k)) {
                        int dist = list_i.size() - k + list_j.size() - k;
                        if (dist <= distance)
                            res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    private void findLeaves(TreeNode node, List<TreeNode> trail, List<TreeNode> leaves,
            Map<TreeNode, List<TreeNode>> map) {
        if (node == null)
            return;
        List<TreeNode> tmp = new ArrayList<>(trail);
        tmp.add(node);
        if (node.left == null && node.right == null) {
            map.put(node, tmp);
            leaves.add(node);
            return;
        }
        findLeaves(node.left, tmp, leaves, map);
        findLeaves(node.right, tmp, leaves, map);
    }
}