class Solution {
    int cnt = 0;

    private void backtrack(boolean[] used, int i) {
        if (i == 1) {
            cnt++;
            return;
        }
        for (int j = 1; j <= used.length; j++) {
            if (!used[j - 1] && (i % j == 0 || j % i == 0)) {
                used[j - 1] = true;
                backtrack(used, i - 1);
                used[j - 1] = false;
            }
        }
    }

    public int countArrangement(int n) {
        backtrack(new boolean[n], n);
        return cnt;
    }
}