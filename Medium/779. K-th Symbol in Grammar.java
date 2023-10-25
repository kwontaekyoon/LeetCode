class Solution {
    public int kthGrammar(int n, int k) {
        /**
         * 0
         * 0 1
         * 01 10
         * 0110 1001
         * 01101001 10010110
         * 0110100110010110 1001011001101001
         */
        if (n == 1) {
            return 0;
        }
        int parent = kthGrammar(n - 1, (k + 1) / 2);
        if (k % 2 == 0) {
            return parent == 1 ? 0 : 1;
        } else {
            return parent;
        }
    }
}