class Solution {
    static byte[] path = new byte[200_001];
    int strtLevel = -1;
    int destLevel = -1;
    int comnLevel = -1;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        findPaths(root, startValue, destValue, 100_000);
        int answerIdx = comnLevel;
        for (int i = strtLevel; i > comnLevel; i--)
            path[--answerIdx] = 'U';
        return new String(path, answerIdx, destLevel - answerIdx);
    }

    private int findPaths(TreeNode node, int strtVal, int destVal, int level) {
        if (node == null)
            return 0;
        int result = 0;
        if (node.val == strtVal) {
            strtLevel = level;
            result = 1;
        } else if (node.val == destVal) {
            destLevel = level;
            result = 1;
        }
        int leftFound = 0;
        int rightFound = 0;
        if (comnLevel < 0) {
            if (destLevel < 0)
                path[level] = 'L';
            leftFound = findPaths(node.left, strtVal, destVal, level + 1);
            rightFound = 0;
            if (comnLevel < 0) {
                if (destLevel < 0)
                    path[level] = 'R';
                rightFound = findPaths(node.right, strtVal, destVal, level + 1);
            }
        }
        if (comnLevel < 0 && leftFound + rightFound + result == 2)
            comnLevel = level;
        return result | leftFound | rightFound;
    }
}

class Solution1 {
    private record Trace(int val, StringBuilder sb) {
    };

    public String getDirections(TreeNode root, int startValue, int destValue) {
        final var map = new HashMap<Integer, Map<Character, Integer>>();
        dfs(root, map);
        final var queue = new ArrayDeque<Trace>();
        final var set = new boolean[map.size() + 1];
        set[startValue] = true;
        queue.offer(new Trace(startValue, new StringBuilder()));
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            if (curr.val == destValue) {
                return curr.sb.toString();
            }
            var next = map.get(curr.val);
            for (var dir : next.keySet()) {
                int dest = next.get(dir);
                if (!set[dest]) {
                    set[dest] = true;
                    queue.offer(new Trace(dest, new StringBuilder(curr.sb).append(dir)));
                }
            }
        }
        return "";
    }

    private void dfs(TreeNode node, Map<Integer, Map<Character, Integer>> map) {
        if (node.left != null) {
            map.computeIfAbsent(node.val, k -> new HashMap<Character, Integer>()).put('L', node.left.val);
            map.computeIfAbsent(node.left.val, k -> new HashMap<Character, Integer>()).put('U', node.val);
            dfs(node.left, map);
        }
        if (node.right != null) {
            map.computeIfAbsent(node.val, k -> new HashMap<Character, Integer>()).put('R', node.right.val);
            map.computeIfAbsent(node.right.val, k -> new HashMap<Character, Integer>()).put('U', node.val);
            dfs(node.right, map);
        }
    }
}