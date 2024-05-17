class Solution {
    private final static int MOD = (int) 1e9 + 7;
    private long maxProd = 0;

    public int maxProduct(TreeNode root) {
        final var totalSum = calculate(root);
        dfs(root, totalSum);
        return (int) (maxProd % MOD);
    }

    private int dfs(TreeNode curr, int totalSum) {
        if (curr == null) {
            return 0;
        }
        int currSum = dfs(curr.left, totalSum) + dfs(curr.right, totalSum) + curr.val;
        maxProd = Math.max(maxProd, (long) (totalSum - currSum) * currSum);
        return currSum;
    }

    private int calculate(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        return calculate(curr.left) + calculate(curr.right) + curr.val;
    }
}