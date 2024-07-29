class Solution {
    public int numTeams(int[] rating) {
        final int n = rating.length;
        int cnt = 0;
        final var smallerCntOnLeft = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (rating[j] < rating[i]) {
                    smallerCntOnLeft[i]++;
                    cnt += smallerCntOnLeft[j];
                }
            }
        }
        final var biggerCntOnLeft = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (rating[j] > rating[i]) {
                    biggerCntOnLeft[i]++;
                    cnt += biggerCntOnLeft[j];
                }
            }
        }
        return cnt;
    }
}

class BruteForce {
    public int numTeams(int[] rating) {
        final int n = rating.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rating[i] >= rating[j]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (rating[j] >= rating[k]) {
                        continue;
                    }
                    cnt++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rating[i] <= rating[j]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (rating[j] <= rating[k]) {
                        continue;
                    }
                    cnt++;
                }
            }
        }
        return cnt;
    }
}