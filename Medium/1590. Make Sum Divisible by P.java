import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        var sum = 0L;
        for (int num : nums) {
            sum += num;
        }
        final int res = (int) (sum % p);
        if (res == 0) {
            return 0;
        }
        final int n = nums.length;
        final var resMap = new HashMap<Integer, Integer>();
        resMap.put(0, -1);
        int min = n;
        for (int i = 0, prefixRes = 0; i < n; i++) {
            prefixRes = (prefixRes + nums[i]) % p;
            int targetRes = (prefixRes - res + p) % p;
            if (resMap.containsKey(targetRes)) {
                min = Math.min(min, i - resMap.get(targetRes));
            }
            resMap.put(prefixRes, i);
        }
        return min == n ? -1 : min;
    }
}