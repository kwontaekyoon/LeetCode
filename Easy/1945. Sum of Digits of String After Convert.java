class Solution {
    public int getLucky(String s, int k) {
        int res = 0;
        for (var c : s.toCharArray()) {
            int num = c - 'a' + 1;
            res += (num / 10 + num % 10);
        }
        for (int i = 1; i < k; i++) {
            int newRes = 0;
            while (res > 0) {
                newRes += res % 10;
                res /= 10;
            }
            res = newRes;
        }
        return res;
    }
}