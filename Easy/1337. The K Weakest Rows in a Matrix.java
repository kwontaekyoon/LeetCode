class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int R = mat.length, C = mat[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= C; i++) {
            ans.add(new ArrayList<>());
        }
        for (int r = 0; r < R; r++) {
            int sum = 0;
            for (int c = 0; c < C; c++) {
                if (mat[r][c] == 1) {
                    sum += 1;
                } else {
                    break;
                }
            }
            ans.get(sum).add(r);
        }
        int cnt = 0;
        int[] res = new int[k];
        for (List<Integer> sum : ans) {
            for (int r : sum) {
                res[cnt++] = r;
                if (cnt == k) {
                    return res;
                }
            }
        }
        return res;
    }
}