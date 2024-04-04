class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int curDepth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                curDepth++;
            } else if (c == ')') {
                maxDepth = Math.max(maxDepth, curDepth--);
            }
        }
        return maxDepth;
    }
}