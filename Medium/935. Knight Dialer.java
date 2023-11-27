class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int knightDialer(int n) {
        long[] mem = new long[10];
        Arrays.fill(mem, 1);
        for (int i = 1; i < n; i++) {
            long[] tmp = new long[10];
            tmp[0] = (mem[4] + mem[6]) % MOD;
            tmp[1] = (mem[6] + mem[8]) % MOD;
            tmp[2] = (mem[7] + mem[9]) % MOD;
            tmp[3] = (mem[4] + mem[8]) % MOD;
            tmp[4] = (mem[0] + mem[3] + mem[9]) % MOD;
            tmp[6] = (mem[0] + mem[1] + mem[7]) % MOD;
            tmp[7] = (mem[2] + mem[6]) % MOD;
            tmp[8] = (mem[1] + mem[3]) % MOD;
            tmp[9] = (mem[2] + mem[4]) % MOD;
            mem = tmp;
        }
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = (ans + mem[i]) % MOD;
        }
        return (int) ans;
    }
}

// class Solution {
// private static final int MOD = (int) 1e9 + 7;
// private Map<Integer, List<Integer>> numToPaths;
// private long ans = 0;
// private void init() {
// numToPaths = new HashMap<>();
// for (int i = 0; i < 10; i++) {
// numToPaths.put(i, new ArrayList<>());
// }
// numToPaths.get(1).addAll(List.of(6, 8));
// numToPaths.get(2).addAll(List.of(7, 9));
// numToPaths.get(3).addAll(List.of(4, 8));
// numToPaths.get(4).addAll(List.of(0, 3, 9));
// numToPaths.get(6).addAll(List.of(0, 1, 7));
// numToPaths.get(7).addAll(List.of(2, 6));
// numToPaths.get(8).addAll(List.of(1, 3));
// numToPaths.get(9).addAll(List.of(2, 4));
// numToPaths.get(0).addAll(List.of(4, 6));
// }
// private void dfs(int length, int target, int current) {
// if (length == target) {
// ans++;
// return;
// }
// for (int path : numToPaths.get(current)) {
// dfs(length + 1, target, path);
// }
// }
// public int knightDialer(int n) {
// init();
// for (int i = 0; i < 10; i++) {
// dfs(1, n, i);
// }
// return (int) ans % MOD;
// }
// }