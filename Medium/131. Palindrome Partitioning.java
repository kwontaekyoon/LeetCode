class Solution {
    private final List<List<String>> res = new ArrayList<>();
    private final List<String> list = new ArrayList<>();
    private int N;
    private char[] chars;
    private boolean[][] dp;
    private String[][] subs;

    public List<List<String>> partition(String s) {
        chars = s.toCharArray();
        N = chars.length;
        dp = new boolean[N][N];
        subs = new String[N][N];
        dfs(0);
        return res;
    }

    private void dfs(int startIndex) {
        if (startIndex == N) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = startIndex; i < N; i++) {
            if (dp[startIndex][i] || isPalindrome(startIndex, i)) {
                dp[startIndex][i] = true;
                if (subs[startIndex][i] == null) {
                    subs[startIndex][i] = String.valueOf(chars, startIndex, i - startIndex + 1);
                }
                list.add(subs[startIndex][i]);
                dfs(i + 1);
                list.removeLast();
            }
        }
    }

    private boolean isPalindrome(int l, int r) {
        while (l < r) {
            if (chars[l++] != chars[r--]) {
                return false;
            }
        }
        return true;
    }
}