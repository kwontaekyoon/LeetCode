class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int cnt = computeWithCurr(curr, n);
            if (k >= cnt) {
                curr++;
                k -= cnt;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }

    private int computeWithCurr(int prefix, int n) {
        long firstNum = prefix, nextNum = prefix + 1;
        int cnt = 0;

        while (firstNum <= n) {
            cnt += Math.min(n + 1, nextNum) - firstNum;
            firstNum *= 10;
            nextNum *= 10;
        }

        return cnt;
    }
}