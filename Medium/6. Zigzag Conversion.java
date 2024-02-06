class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        int offset = numRows == 1 ? 1 : 2 * (numRows - 1);
        StringBuilder res = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            int idx = r;
            while (idx < len) {
                res.append(s.charAt(idx));
                if (idx % offset != 0 && idx % offset != numRows - 1) {
                    int diagonalOffset = 2 * (numRows - r - 1);
                    if (idx + diagonalOffset < len) {
                        res.append(s.charAt(idx + diagonalOffset));
                    }
                }
                idx += offset;
            }
        }
        return res.toString();
    }
}