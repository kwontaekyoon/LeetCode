class Solution {
    public int heightChecker(int[] heights) {
        final var cnt = new int[101];
        for (int height : heights) {
            cnt[height]++;
        }
        int top = 0, res = 0;
        for (int i = 1; i < 101; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            for (int j = top; j < top + cnt[i]; j++) {
                if (heights[j] != i) {
                    res++;
                }
            }
            top += cnt[i];
        }
        return res;
    }
}

class Solution1 {
    public int heightChecker(int[] heights) {
        final int N = heights.length;
        final var ordered = Arrays.copyOf(heights, N);
        Arrays.sort(ordered);
        int check = 0;
        for (int i = 0; i < N; i++) {
            if (heights[i] != ordered[i]) {
                check++;
            }
        }
        return check;
    }
}