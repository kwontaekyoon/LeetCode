class Solution {
    private List<String> res = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    private void dfs(int open, int close, int target) {
        if (2 * target == sb.length()) {
            res.add(sb.toString());
        } else {
            if (open < target) {
                sb.append('(');
                dfs(open + 1, close, target);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (close < open) {
                sb.append(')');
                dfs(open, close + 1, target);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n);
        return res;
    }
}