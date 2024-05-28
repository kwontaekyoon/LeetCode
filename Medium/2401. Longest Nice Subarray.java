class Solution {
    public int longestNiceSubarray(int[] nums) {
        final int N = nums.length;
        int bit = 0, l = 0, res = 0;
        for (int r = 0; r < N; r++) {
            while ((bit & nums[r]) != 0) {
                bit ^= nums[l++];
            }
            bit |= nums[r];
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

class Solution1 {
    public int longestNiceSubarray(int[] nums) {
        final int N = nums.length;
        final var bits = new int[32];
        int longest = 1;
        for (int end = 0, start = 0; end < N; end++) {
            update(bits, true, nums[end]);
            while (!check(bits)) {
                update(bits, false, nums[start]);
                start++;
            }
            longest = Math.max(longest, end - start + 1);
        }
        return longest;
    }

    private void update(int[] bits, boolean up, int num) {
        for (int i = 0; i < 32 && num > 0; i++, num /= 2) {
            bits[i] += num % 2 * (up ? 1 : -1);
        }
    }

    private boolean check(int[] bits) {
        for (var bit : bits) {
            if (bit > 1) {
                return false;
            }
        }
        return true;
    }
}