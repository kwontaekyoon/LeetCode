class UnionFind {
    int[] parent;
    int[] rank;
    int count;

    public int regionsBySlashes(String[] grid) {
        int rows = grid.length;
        int dots = rows + 1;
        parent = new int[dots * dots];
        rank = new int[dots * dots];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < dots; i++) {
            for (int j = 0; j < dots; j++) {
                if (i == 0 || j == 0 || i == rows || j == rows) {
                    int cells = i * dots + j;
                    union(0, cells);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            char[] ch = grid[i].toCharArray();
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == '\\') {
                    int cell1 = i * dots + j;
                    int cell2 = (i + 1) * dots + (j + 1);
                    union(cell1, cell2);
                } else if (ch[j] == '/') {
                    int cell1 = (i + 1) * dots + j;
                    int cell2 = i * dots + (j + 1);
                    union(cell1, cell2);
                }
            }
        }
        return count;
    }

    public void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA == parentB) {
            count++;
        } else {
            if (rank[parentA] > rank[parentB]) {
                parent[parentB] = parentA;
            } else if (rank[parentA] < rank[parentB]) {
                parent[parentA] = parentB;
            } else {
                parent[parentB] = parentA;
                rank[parentA]++;
            }
        }
    }

    public int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        int temp = find(parent[a]);
        parent[a] = temp;
        return temp;
    }
}

class DFS {
    public int regionsBySlashes(String[] grid) {
        int[][][] meme = new int[grid.length][grid.length][4];
        char[][] grids = new char[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            grids[i] = grid[i].toCharArray();
        }
        int res = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                for (int k = 0; k <= 3; k++) {
                    if (meme[i][j][k] == 0) {
                        dfs(grids, meme, i, j, k, res);
                        res++;
                    }
                }
            }
        }
        return res - 1;
    }

    public void dfs(char[][] grids, int[][][] meme, int i, int j, int k, int res) {
        meme[i][j][k] = res;
        if (k == 0) {
            if (i > 0 && meme[i - 1][j][2] == 0)
                dfs(grids, meme, i - 1, j, 2, res);
            if (grids[i][j] == ' ' && meme[i][j][2] == 0)
                dfs(grids, meme, i, j, 2, res);
            if (grids[i][j] != '\\' && meme[i][j][3] == 0)
                dfs(grids, meme, i, j, 3, res);
            if (grids[i][j] != '/' && meme[i][j][1] == 0)
                dfs(grids, meme, i, j, 1, res);
        } else if (k == 1) {
            if (j < grids.length - 1 && meme[i][j + 1][3] == 0)
                dfs(grids, meme, i, j + 1, 3, res);
            if (grids[i][j] == ' ' && meme[i][j][3] == 0)
                dfs(grids, meme, i, j, 3, res);
            if (grids[i][j] != '\\' && meme[i][j][2] == 0)
                dfs(grids, meme, i, j, 2, res);
            if (grids[i][j] != '/' && meme[i][j][0] == 0)
                dfs(grids, meme, i, j, 0, res);
        } else if (k == 2) {
            if (i < grids.length - 1 && meme[i + 1][j][0] == 0)
                dfs(grids, meme, i + 1, j, 0, res);
            if (grids[i][j] == ' ' && meme[i][j][0] == 0)
                dfs(grids, meme, i, j, 0, res);
            if (grids[i][j] != '\\' && meme[i][j][1] == 0)
                dfs(grids, meme, i, j, 1, res);
            if (grids[i][j] != '/' && meme[i][j][3] == 0)
                dfs(grids, meme, i, j, 3, res);
        } else {
            if (j > 0 && meme[i][j - 1][1] == 0)
                dfs(grids, meme, i, j - 1, 1, res);
            if (grids[i][j] == ' ' && meme[i][j][1] == 0)
                dfs(grids, meme, i, j, 1, res);
            if (grids[i][j] != '\\' && meme[i][j][0] == 0)
                dfs(grids, meme, i, j, 0, res);
            if (grids[i][j] != '/' && meme[i][j][2] == 0)
                dfs(grids, meme, i, j, 2, res);
        }
    }
}

// failed
class Solution1 {
    public int regionsBySlashes(String[] grid) {
        final int n = grid.length;
        final var map = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r].charAt(c) == ' ') {
                    map[r][c] = 0;
                } else if (grid[r].charAt(c) == '/') {
                    map[r][c] = 1;
                } else {
                    map[r][c] = -1;
                }
            }
        }
        int res = 1;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if ((map[r][c] == 1 && checkSlash(map, n, r, c)) ||
                        (map[r][c] == -1 && checkBackSlash(map, n, r, c))) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean checkSlash(int[][] map, int n, int r, int c) {
        if (r != 0 && c != n - 1) {
            return false;
        }
        int iter = r == 0 ? c + 1 : n - r;
        for (int i = 0; i < iter; i++) {
            if (map[r + i][c - i] != 1) {
                return false;
            }
        }
        return true;
    }

    private boolean checkBackSlash(int[][] map, int n, int r, int c) {
        if (r != 0 && c != 0) {
            return false;
        }
        int iter = r == 0 ? n - c : n - r;
        for (int i = 0; i < iter; i++) {
            if (map[r + i][c + i] != -1) {
                return false;
            }
        }
        return true;
    }
}