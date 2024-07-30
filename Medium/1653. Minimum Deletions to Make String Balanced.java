class DP {
    public int minimumDeletions(String s) {
        final var n = s.length();
        final var dp = new int[n + 1];
        for (int i = 0, b = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                dp[i + 1] = Math.min(dp[i] + 1, b);
            } else {
                dp[i + 1] = dp[i];
                b++;
            }
        }
        return dp[n];
    }
}

class PrefixSum {
    public int minimumDeletions(String s) {
        final var n = s.length();
        final var leftB = new int[n];
        final var rightA = new int[n];
        for (int i = 0, b = 0; i < n; i++) {
            leftB[i] = b;
            if (s.charAt(i) == 'b') {
                b++;
            }
        }
        for (int i = n - 1, a = 0; i >= 0; i--) {
            rightA[i] = a;
            if (s.charAt(i) == 'a') {
                a++;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, leftB[i] + rightA[i]);
        }
        return res;
    }
}