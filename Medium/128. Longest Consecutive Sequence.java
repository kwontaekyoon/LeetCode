class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Set<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!hs.remove(num)) {
                continue;
            }
            int length = 1;
            for (int l = num - 1; hs.remove(l); l--) {
                length++;
            }
            for (int r = num + 1; hs.remove(r); r++) {
                length++;
            }
            res = Math.max(res, length);
        }
        return res;
    }
}