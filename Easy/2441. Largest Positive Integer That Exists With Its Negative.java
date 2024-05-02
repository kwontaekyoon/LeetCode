class Solution {
    public int findMaxK(int[] nums) {
        final var map = new int[1001];
        int max = -1;
        for (int num : nums) {
            int idx = Math.abs(num);
            if (idx <= max) {
                continue;
            }
            if (map[idx] == -num) {
                max = Math.max(max, idx);
            } else {
                map[idx] = num;
            }
        }
        return max;
    }
}

class UsingHashTable {
    public int findMaxK(int[] nums) {
        final var set = new HashSet<Integer>();
        int max = -1;
        for (int num : nums) {
            int curr = Math.abs(num);
            if (curr <= max) {
                continue;
            }
            if (set.contains(-num)) {
                max = Math.max(max, curr);
            } else {
                set.add(num);
            }
        }
        return max;
    }
}