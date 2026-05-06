class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int rows = boxGrid.length;
        int cols = boxGrid[0].length;
        
        // Result dimensions are swapped: [cols][rows]
        char[][] res = new char[cols][rows];
        
        // Fill result with empty space initially
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                res[i][j] = '.';
            }
        }

        for (int r = 0; r < rows; r++) {
            // Tracks where the next stone should 'land' in the rotated grid
            // In original row r, the rightmost available column is cols - 1
            int dropPos = cols - 1;
            
            for (int c = cols - 1; c >= 0; c--) {
                if (boxGrid[r][c] == '#') {
                    // Place stone at its dropped position in the rotated grid
                    // Mapping: (r, c) -> (c, rows - 1 - r)
                    // But for stones, we use dropPos instead of c
                    res[dropPos][rows - 1 - r] = '#';
                    dropPos--; 
                } else if (boxGrid[r][c] == '*') {
                    // Obstacles stay fixed relative to their original position
                    res[c][rows - 1 - r] = '*';
                    // Reset drop position to just above the obstacle
                    dropPos = c - 1;
                }
            }
        }
        
        return res;
    }
}
