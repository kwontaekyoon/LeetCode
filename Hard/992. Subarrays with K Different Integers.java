class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length, ans = 0;
        var map = new HashMap<Integer, Integer>();
        for (int l = 0, r = 0; r < n; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            ans += (r - l + 1);
        }

        map.clear();

        for (int l = 0, r = 0; r < n; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.size() >= k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            ans -= (r - l + 1);
        }

        return ans;
    }
}