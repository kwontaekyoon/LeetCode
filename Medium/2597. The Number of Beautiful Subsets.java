class Solution {
    private int[] NUMS;
    private int N, K;
    private int numOfSubs = 0;
    private int[] map = new int[1001];

    public int beautifulSubsets(int[] nums, int k) {
        this.NUMS = nums;
        this.N = nums.length;
        this.K = k;
        Arrays.sort(NUMS);
        dfs(0);
        return numOfSubs;
    }

    private void dfs(int startIndex) {
        for (int i = startIndex; i < N; i++) {
            if (map[Math.max(0, NUMS[i] - K)] > 0) {
                continue;
            }
            numOfSubs++;
            map[NUMS[i]]++;
            dfs(i + 1);
            map[NUMS[i]]--;
        }
    }
}