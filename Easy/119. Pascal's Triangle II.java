class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int r = 1; r <= rowIndex; r++) {
            for (int c = r; c > 0; c--) {
                dp[c] = dp[c] + dp[c - 1];
            }
        }
        return Arrays.asList(dp);
    }
}
/**
 * 1 0 0 0 0
 * 1 1 0 0 0
 * 1 2 1 0 0
 * 1 3 3 1 0
 * 1 4 6 5 1
 * 
 */

// class Solution {
// public List<Integer> getRow(int R) {
// List<List<Integer>> pas = new ArrayList<>(R + 1);
// for (int r = 0; r <= R; r++) {
// pas.add(new ArrayList<>(r + 1));
// for (int c = 0; c <= r; c++) {
// if (c == 0 || c == r) {
// pas.get(r).add(1);
// } else {
// pas.get(r).add(pas.get(r - 1).get(c - 1) + pas.get(r - 1).get(c));
// }
// }
// }
// return pas.get(R);
// }
// }