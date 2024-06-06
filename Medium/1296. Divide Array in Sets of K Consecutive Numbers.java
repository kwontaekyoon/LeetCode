class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        final int N = nums.length;
        final var MAP = new HashMap<Integer, Integer>();
        Arrays.sort(nums);
        for (int num : nums) {
            MAP.put(num, MAP.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            int cnt = MAP.get(num);
            if (cnt == 0) {
                continue;
            }
            for (int i = num; i < num + k; i++) {
                if (MAP.getOrDefault(i, 0) < cnt) {
                    return false;
                }
                MAP.put(i, MAP.get(i) - cnt);
            }
        }
        return true;
    }
}