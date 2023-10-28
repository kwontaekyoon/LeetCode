class Solution {
    private static final int MOD = (int) 1e9 + 7;
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> dp = new HashMap<>();
        for(int num : arr) {
            dp.put(num, 1);
        }
        for (int root : arr) {
            int upperBound = (int) Math.sqrt(root);
            for (int mod : arr) {
                if (mod > upperBound) {
                    break;
                }
                if (root % mod == 0 && dp.containsKey(root / mod)) {
                    long tmp = (long) dp.get(mod) * dp.get(root / mod);
                    dp.put(root, (int) ((dp.get(root) + (root / mod == mod ? tmp : tmp * 2)) % MOD));
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