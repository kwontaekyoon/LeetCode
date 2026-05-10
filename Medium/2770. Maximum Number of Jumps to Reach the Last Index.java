class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dists = new int[n];
        Arrays.fill(dists, -1);
        dists[0] = 0;
        // for (int to = 1; to < n; to++) {
        //     for (int from = 0; from < to; from++) {
        //         if (Math.abs(nums[to] - nums[from]) <= target && dists[from] != -1) {
        //             dists[to] = Math.max(dists[from] + 1, dists[to]);
        //         }
        //     }
        // }
        for (int from = 0; from < n - 1; from++) {
            if (dists[from] == -1) {
                continue;
            }
            for (int to = from + 1; to < n; to++) {
                if (Math.abs(nums[to] - nums[from]) <= target) {
                    dists[to] = Math.max(dists[from] + 1, dists[to]);
                }
            }
        }
        return dists[n - 1];
    }
}
