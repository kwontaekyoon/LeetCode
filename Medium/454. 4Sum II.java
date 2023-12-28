class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // i + j = -(k + l)
        Map<Integer, Integer> countSum = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                countSum.put(sum, countSum.getOrDefault(sum, 0) + 1);
            }
        }
        int ans = 0;
        for (int k : nums3) {
            for (int l : nums4) {
                int sum = -(k + l);
                ans += countSum.getOrDefault(sum, 0);
            }
        }
        return ans;
    }
}