class Solution {
    private class Trie {
        private int cnt;
        private Trie[] child;

        private Trie() {
            cnt = 0;
            child = new Trie[26];
        }
    }

    public int[] sumPrefixScores(String[] words) {
        final var root = new Trie();
        for (var word : words) {
            insert(word, root);
        }
        final var res = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            res[i] = search(words[i], root);
        }
        return res;
    }

    private void insert(String word, Trie root) {
        for (var c : word.toCharArray()) {
            int i = c - 'a';
            if (root.child[i] == null) {
                root.child[i] = new Trie();
            }
            root = root.child[i];
            root.cnt++;
        }
    }

    private int search(String word, Trie root) {
        int cnt = 0;
        for (var c : word.toCharArray()) {
            int i = c - 'a';
            root = root.child[i];
            cnt += root.cnt;
        }
        return cnt;
    }
}