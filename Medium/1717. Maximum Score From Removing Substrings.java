class Solution {
    public int maximumGain(String s, int x, int y) {
        final int lesser = Math.min(x, y);
        int aCnt = 0, bCnt = 0;
        int res = 0;
        for (final var c : s.toCharArray()) {
            if (c == 'a') {
                if (y > x && bCnt > 0) {
                    res += y;
                    bCnt--;
                } else {
                    aCnt++;
                }
            } else if (c == 'b') {
                if (x > y && aCnt > 0) {
                    res += x;
                    aCnt--;
                } else {
                    bCnt++;
                }
            } else {
                res += lesser * Math.min(aCnt, bCnt);
                aCnt = 0;
                bCnt = 0;
            }
        }
        res += lesser * Math.min(aCnt, bCnt);
        return res;
    }
}