class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sum = Arrays.stream(colsum).sum();
        if (sum != upper + lower) {
            return List.of();
        }
        final int C = colsum.length;
        final var one = new Integer[C];
        final var two = new Integer[C];
        Arrays.fill(one, 0);
        Arrays.fill(two, 0);
        for (int c = 0; c < C; c++) {
            if (colsum[c] == 2) {
                if (upper <= 0 || lower <= 0) {
                    return List.of();
                }
                one[c]++;
                upper--;
                two[c]++;
                lower--;
                colsum[c] = 0;
            }
        }
        for (int c = 0; c < C; c++) {
            if (colsum[c] > 0) {
                if (upper > 0 && one[c] == 0) {
                    one[c]++;
                    upper--;
                } else if (lower > 0 && two[c] == 0) {
                    two[c]++;
                    lower--;
                } else {
                    return List.of();
                }
                colsum[c]--;
            }
        }
        return List.of(Arrays.asList(one), Arrays.asList(two));
    }
}