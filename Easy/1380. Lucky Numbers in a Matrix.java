class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        final var res = new ArrayList<Integer>();
        final int r = matrix.length, c = matrix[0].length;
        out: for (int i = 0; i < r; i++) {
            int minCol = -1, minVal = Integer.MAX_VALUE;
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] < minVal) {
                    minCol = j;
                    minVal = matrix[i][j];
                }
            }
            for (int k = 0; k < r; k++) {
                if (matrix[k][minCol] > minVal) {
                    continue out;
                }
            }
            res.add(minVal);
        }
        return res;
    }
}

class Solution1 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        final var minColOfRows = new ArrayList<Integer>();
        final int r = matrix.length, c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            int minIdx = -1, minVal = Integer.MAX_VALUE;
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] < minVal) {
                    minIdx = j;
                    minVal = matrix[i][j];
                }
            }
            minColOfRows.add(minIdx);
        }
        final var lucky = new ArrayList<Integer>();
        out: for (int i = 0; i < minColOfRows.size(); i++) {
            int minColOfRowI = minColOfRows.get(i);
            int minValOfRowI = matrix[i][minColOfRowI];
            for (int j = 0; j < r; j++) {
                if (minValOfRowI < matrix[j][minColOfRowI]) {
                    continue out;
                }
            }
            lucky.add(minValOfRowI);
        }
        return lucky;
    }
}