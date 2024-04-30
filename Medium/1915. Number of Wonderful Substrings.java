class Solution {
    public long wonderfulSubstrings(String word) {
        // final var map = new HashMap<Integer, Integer>();
        final var cnt = new int[1024];
        // map.put(0, 1);
        cnt[0] = 1;
        long res = 0;
        int bit = 0;

        for (var c : word.toCharArray()) {
            bit ^= 1 << (c - 'a');
            // res += map.getOrDefault(bit, 0);
            res += cnt[bit];
            for (int i = 0; i < 10; i++) {
                // res += map.getOrDefault(bit ^ (1 << i), 0);
                res += cnt[bit ^ (1 << i)];
            }
            // map.put(bit, map.getOrDefault(bit, 0) + 1);
            cnt[bit] += 1;
        }

        return res;
    }
}