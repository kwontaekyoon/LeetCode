import java.util.HashSet;

class Solution {
    class Node {
        Node[] child;
        boolean isEnd;

        Node() {
            child = new Node[26];
            isEnd = false;
        }
    }

    public int minExtraChar(String s, String[] dictionary) {
        final var root = new Node();
        for (var word : dictionary) {
            insert(word, root);
        }
        final int n = s.length();
        final var dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < n; i++) {
            search(s, root, dp, i, n);
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
        }
        return dp[n];
    }

    private void search(String s, Node root, int[] dp, int start, int n) {
        for (int i = start; i < n; i++) {
            int next = s.charAt(i) - 'a';
            if (root.child[next] == null) {
                return;
            }
            root = root.child[next];
            if (root.isEnd) {
                dp[i + 1] = Math.min(dp[i + 1], dp[start]);
            }
        }
    }

    private void insert(String s, Node node) {
        for (var c : s.toCharArray()) {
            int next = c - 'a';
            if (node.child[next] == null) {
                node.child[next] = new Node();
            }
            node = node.child[next];
        }
        node.isEnd = true;
    }
}

class HashTable {
    public int minExtraChar(String s, String[] dictionary) {
        final int n = s.length();
        final var dp = new int[n + 1];
        final var set = new HashSet<String>();
        for (var word : dictionary) {
            set.add(word);
        }
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = i; j > 0; j--) {
                if (set.contains(s.substring(i - j, i))) {
                    dp[i] = Math.min(dp[i], dp[i - j]);
                }
            }
        }
        return dp[n];
    }
}

class Solution1 {
    public int minExtraChar(String s, String[] dictionary) {
        final int n = s.length();
        final var dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (var word : dictionary) {
                int size = word.length();
                if (size > i) {
                    continue;
                }
                if (s.substring(i - size, i).equals(word)) {
                    dp[i] = Math.min(dp[i], dp[i - size]);
                }
            }
        }
        return dp[n];
    }
}