class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        final var cnt = new int[1001];
        for (int num : nums1) {
            cnt[num]++;
        }
        final var ans = new int[1001];
        int i = 0;
        for (int num : nums2) {
            if (cnt[num] > 0) {
                ans[i++] = num;
            }
            cnt[num]--;
        }
        return Arrays.copyOfRange(ans, 0, i);
    }
}