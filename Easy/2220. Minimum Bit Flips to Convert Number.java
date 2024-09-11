class Solution {
    public int minBitFlips(int start, int goal) {
        int cnt = 0;
        while (start > 0 || goal > 0) {
            cnt += start % 2 != goal % 2 ? 1 : 0;
            start /= 2;
            goal /= 2;
        }
        return cnt;
    }
}