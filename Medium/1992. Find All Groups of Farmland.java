class Solution {
    public int[][] findFarmland(int[][] land) {
        final int R = land.length, C = land[0].length;
        final var list = new ArrayList<int[]>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (land[r][c] == 1) {
                    list.add(new int[] { r, c, 0, 0 });
                    dfs(land, R, C, r, c, list);
                }
            }
        }
        
        return list.toArray(new int[0][4]);
    }

    private void dfs(int[][] land, int R, int C, int r, int c, List<int[]> list) {
        if (r < 0 || c < 0 || r >= R || c >= C || land[r][c] != 1) {
            return;
        }
        land[r][c] = -1;
        if ((r == R - 1 || land[r + 1][c] == 0) && (c == C - 1 || land[r][c + 1] == 0)) {
            var slot = list.get(list.size() - 1);
            slot[2] = r;
            slot[3] = c;
        }
        dfs(land, R, C, r + 1, c, list);
        dfs(land, R, C, r, c + 1, list);
    }
}