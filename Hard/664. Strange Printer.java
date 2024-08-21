import java.util.Arrays;

class Solution {
    public int strangePrinter(String s) {
        final var chars = s.toCharArray();
        final int n = chars.length;
        final var dp = new int[n][n];
        return memo(dp, chars, 0, n - 1);
    }

    private int memo(int[][] dp, char[] chars, int i, int j) {
        if (i >= j) {
            return i == j ? 1 : 0;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        int firstLetter = chars[i];
        int answer = 1 + memo(dp, chars, i + 1, j);
        for (int k = i + 1; k <= j; k++) {
            if (chars[k] == firstLetter) {
                int betterAnswer = memo(dp, chars, i, k - 1) + memo(dp, chars, k + 1, j);
                answer = Math.min(answer, betterAnswer);
            }
        }
        return dp[i][j] = answer;
    }
}

// failed
class Solution1 {
    public int strangePrinter(String s) {
        final int n = s.length();
        final var cnt = new int[26];
        cnt[s.charAt(0) - 'a']++;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            cnt[s.charAt(i) - 'a']++;
        }
        Arrays.sort(cnt);
        int res = 1;
        for (int i = 24; i >= 0 && cnt[i] > 0; i--) {
            res += cnt[i];
        }
        return res;
    }
}