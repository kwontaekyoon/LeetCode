class Solution {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        res &= -res;
        final var ans = new int[2];
        for (int num : nums) {
            if ((res & num) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }
}

class Solution1 {
    public int[] singleNumber(int[] nums) {
        final var set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        final var res = new int[2];
        int i = 0;
        for (int num : set) {
            res[i++] = num;
        }
        return res;
    }
}