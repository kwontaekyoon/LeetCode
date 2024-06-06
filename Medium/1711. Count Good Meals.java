class Solution {
    private final static int MOD = (int) 1e9 + 7;

    public int countPairs(int[] nums) {
        final var MAP = new HashMap<Integer, Integer>();
        var res = 0L;
        for (int num : nums) {
            for (int i = 0, pow = 1; i < 22; i++, pow *= 2) {
                if (MAP.containsKey(pow - num)) {
                    res += MAP.get(pow - num);
                    res %= MOD;
                }
            }
            MAP.put(num, MAP.getOrDefault(num, 0) + 1);
        }
        return (int) res;
    }
}