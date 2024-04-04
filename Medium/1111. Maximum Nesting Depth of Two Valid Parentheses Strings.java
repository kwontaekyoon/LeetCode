class Solution {
    public int[] maxDepthAfterSplit(String s) {
        int n = s.length();
        var res = new int[n];
        int d = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                res[i] = ++d % 2;
            } else {
                res[i] = d-- % 2;
            }
        }
        return res;
    }
}