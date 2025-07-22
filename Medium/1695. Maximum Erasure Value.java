import java.util.HashMap;

class Solution1 {
    public int maximumUniqueSubarray(int[] nums) {
        final var n = nums.length;
        final var map = new HashMap<Integer, Integer>();
        int curr = 0, result = 0;
        for (int l = 0, r = 0; r < n; r++) {
            if (map.containsKey(nums[r])) {
                int bound = map.get(nums[r]);
                while (l <= bound) {
                    curr -= nums[l];
                    map.remove(nums[l]);
                    l += 1;
                }
            }
            curr += nums[r];
            map.put(nums[r], r);
            result = Math.max(result, curr);
        }
        return result;
    }
}

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        final var cnt = new HashMap<Integer, Integer>();
        int result = 0, curr = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            cnt.put(nums[r], cnt.getOrDefault(nums[r], 0) + 1);
            curr += nums[r];
            while (cnt.get(nums[r]) > 1) {
                cnt.put(nums[l], cnt.get(nums[l]) - 1);
                curr -= nums[l++];
            }
            result = Math.max(result, curr);
        }
        return result;
    }
}