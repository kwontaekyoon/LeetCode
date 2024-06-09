class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        final var map = new int[k];
        int pre = 0, cnt = 0;
        for (int num : nums) {
            pre += num;
            cnt += pre % k == 0 ? 1 : 0;
            int offset = (pre % k + k) % k;
            cnt += map[offset];
            map[offset]++;
        }
        return cnt;
    }
}

class Solution1 {
    public int subarraysDivByK(int[] nums, int k) {
        final var map = new HashMap<Integer, Integer>();
        int prefix = 0, cnt = 0;
        for (int num : nums) {
            prefix += num;
            if (prefix % k == 0) {
                cnt++;
            }
            int offset = prefix % k > 0 ? prefix % k : k + prefix % k;
            cnt += map.getOrDefault(offset, 0);
            map.put(offset, map.getOrDefault(offset, 0) + 1);
        }
        return cnt;
    }
}