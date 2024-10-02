import java.util.Arrays;

class Solution1 {
    public int[] arrayRankTransform(int[] arr) {
        final int n = arr.length;
        final var valAndIdx = new int[n][2];
        for (int i = 0; i < n; i++) {
            valAndIdx[i][0] = arr[i];
            valAndIdx[i][1] = i;
        }
        Arrays.sort(valAndIdx, (x, y) -> Integer.compare(x[0], y[0]));
        int prevVal = Integer.MIN_VALUE;
        int currRank = 0;
        for (int i = 0; i < n; i++) {
            if (prevVal < valAndIdx[i][0]) {
                prevVal = valAndIdx[i][0];
                currRank++;
            }
            arr[valAndIdx[i][1]] = currRank;
        }
        return arr;
    }
}