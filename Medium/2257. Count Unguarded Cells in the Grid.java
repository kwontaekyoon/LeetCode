class Solution {
    public int countUnguarded(int R, int C, int[][] guards, int[][] walls) {
        final int[][] map = new int[R][C];
        int result = R * C;
        for (int[] guard : guards) {
            map[guard[0]][guard[1]] = 1;
            result -= 1;
        }
        for (int[] wall : walls) {
            map[wall[0]][wall[1]] = 1;
            result -= 1;
        }
        final int[] DIRS = { 0, 1, 0, -1, 0 };
        for (int[] guard : guards) {
            for (int i = 0; i < 4; i++) {
                int dr = DIRS[i], dc = DIRS[i + 1];
                int cr = guard[0] + dr, cc = guard[1] + dc;
                while (cr > -1 && cr < R && cc > -1 && cc < C && map[cr][cc] != 1) {
                    if (map[cr][cc] == 0) {
                        result -= 1;
                        map[cr][cc] = 2;
                    }
                    cr += dr;
                    cc += dc;
                }
            }
        }
        return result;
    }
}