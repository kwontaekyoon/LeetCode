class Modified {
    public int maxSubarrayLength(int[] nums, int k) {
        var map = new HashMap<Integer, ArrayDeque<Integer>>();
        int ans = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            map.computeIfAbsent(nums[r], key -> new ArrayDeque<>()).offer(r);
            if (map.get(nums[r]).size() > k) {
                if (map.get(nums[r]).peekFirst() >= l) {
                    l = map.get(nums[r]).peekFirst() + 1;
                }
                map.get(nums[r]).poll();
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}

class Naive {
    public int maxSubarrayLength(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        int res = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.get(nums[r]) > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}