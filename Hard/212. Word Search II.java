class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        final var res = new ArrayList<String>();
        final var root = buildTries(words);
        final int R = board.length, C = board[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                backtrack(board, r, c, root, res);
            }
        }
        return res;
    }

    private void backtrack(char[][] board, int r, int c, TreeNode p, List res) {
        char cur = board[r][c];
        if (cur == '£' || p.next[cur - 'a'] == null) return;
        p = p.next[cur - 'a'];
        if (p.word != null) {
            res.add(p.word);
            p.word = null;
        }

        board[r][c] = '£';
        if (r > 0) backtrack(board, r - 1, c, p, res);
        if (c > 0) backtrack(board, r, c - 1, p, res);
        if (r < board.length - 1) backtrack(board, r + 1, c, p, res);
        if (c < board[0].length - 1) backtrack(board, r, c + 1, p, res);
        board[r][c] = cur;
    }

    public TreeNode buildTries(String[] words) {
        TreeNode root = new TreeNode();
        for (String w : words) {
            TreeNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TreeNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
}

class TreeNode {
    TreeNode[] next = new TreeNode[26];
    String word;
}
}