class Solution {
    public int passThePillow(int n, int time) {
        int res = time % (n - 1);
        int rep = time / (n - 1);
        if (rep % 2 > 0) {
            return n - res;
        } else {
            return 1 + res;
        }
    }
}