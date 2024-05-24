class Solution {
    public int maximumGood(int[][] statements) {
        final int N = statements.length;
        final var arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (statements[i][j] == 2) {
                    continue;
                }
                if (statements[i][j] == 0) {
                    arr[i][1] |= (1 << j);
                } else {
                    arr[i][0] |= (1 << j);
                }
            }
        }
        int res = 0;
        for (int bitmask = 0; bitmask < 1 << N; bitmask++) {
            if (isValid(bitmask, arr, N)) {
                res = Math.max(res, Integer.bitCount(bitmask));
            }
        }
        return res;
    }

    private boolean isValid(int bitmask, int[][] arr, int N) {
        for (int i = 0; i < N; i++) {
            if ((bitmask & (1 << i)) == 0) {
                continue;
            }
            if ((arr[i][0] & bitmask) != arr[i][0]) {
                return false;
            }
            if ((arr[i][1] & bitmask) > 0) {
                return false;
            }
        }
        return true;
    }
}

class Solution1 {
    public int maximumGood(int[][] S) {
        final int N = S.length;
        int res = 0;
        for (int i = 1 << N; i < 1 << (N + 1); i++) {
            final var judge = Integer.toBinaryString(i).substring(1);
            if (check(judge, S, N)) {
                res = Math.max(res, Integer.bitCount(Integer.parseInt(judge, 2)));
            }
        }
        return res;
    }

    private boolean check(String s, int[][] S, int N) {
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == '0') {
                continue;
            }
            for (int j = 0; j < N; j++) {
                if (S[i][j] == 2) {
                    continue;
                }
                if (S[i][j] == 0 && s.charAt(j) == '1') {
                    return false;
                }
                if (S[i][j] == 1 && s.charAt(j) == '0') {
                    return false;
                }
            }
        }
        return true;
    }
}
