class Solution {
    private static final int MOD = (int) 1e9 + 7;
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Integer> dp = new HashMap<>();
        for(int num : arr) {
            hs.add(num);
            dp.put(num, 1);
        }
        for (int i : arr) {
            for (int j : arr) {
                if (j > Math.sqrt(i)) {
                    break;
                }
                if (i % j == 0 && hs.contains(i / j)) {
                    long tmp = (long) dp.get(j) * dp.get(i / j);
                    dp.put(i, (int) ((dp.get(i) + (i / j == j ? tmp : tmp * 2)) % MOD));
                }
            }
        }

        int res = 0;
        for (int val : dp.values()) {
            res  = (res + val) % MOD;
        }
        return res;
    }
}