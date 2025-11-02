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

/**
 * Improved, readable and O(R * C) implementation.
 */
class ImprovedSolution {
    public int countUnguarded(int R, int C, int[][] guards, int[][] walls) {
        final int EMPTY = 0;
        final int GUARD = 1;
        final int GUARDED = 2;
        final int WALL = 3;

        int[][] grid = new int[R][C];
        int unguarded = R * C;

        // Place guards
        for (int[] g : guards) {
            int r = g[0], c = g[1];
            if (grid[r][c] == EMPTY) {
                grid[r][c] = GUARD;
                unguarded--;
            }
        }
        // Place walls
        for (int[] w : walls) {
            int r = w[0], c = w[1];
            if (grid[r][c] == EMPTY) {
                grid[r][c] = WALL;
                unguarded--;
            } else if (grid[r][c] == GUARD) {
                // guard and wall not expected to overlap per problem, but handle defensively
                grid[r][c] = WALL;
            }
        }

        // Row-wise scans
        for (int r = 0; r < R; r++) {
            boolean seenGuard = false;
            // left -> right
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == WALL) {
                    seenGuard = false;
                } else if (grid[r][c] == GUARD) {
                    seenGuard = true;
                } else if (seenGuard && grid[r][c] == EMPTY) {
                    grid[r][c] = GUARDED;
                    unguarded--;
                }
            }
            seenGuard = false;
            // right -> left
            for (int c = C - 1; c >= 0; c--) {
                if (grid[r][c] == WALL) {
                    seenGuard = false;
                } else if (grid[r][c] == GUARD) {
                    seenGuard = true;
                } else if (seenGuard && grid[r][c] == EMPTY) {
                    grid[r][c] = GUARDED;
                    unguarded--;
                }
            }
        }

        // Column-wise scans
        for (int c = 0; c < C; c++) {
            boolean seenGuard = false;
            // top -> bottom
            for (int r = 0; r < R; r++) {
                if (grid[r][c] == WALL) {
                    seenGuard = false;
                } else if (grid[r][c] == GUARD) {
                    seenGuard = true;
                } else if (seenGuard && grid[r][c] == EMPTY) {
                    grid[r][c] = GUARDED;
                    unguarded--;
                }
            }
            seenGuard = false;
            // bottom -> top
            for (int r = R - 1; r >= 0; r--) {
                if (grid[r][c] == WALL) {
                    seenGuard = false;
                } else if (grid[r][c] == GUARD) {
                    seenGuard = true;
                } else if (seenGuard && grid[r][c] == EMPTY) {
                    grid[r][c] = GUARDED;
                    unguarded--;
                }
            }
        }

        return unguarded;
    }
}