class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        final int N = nums.length;
        final var cnt = new int[N + 1];
        cnt[0] = 1;
        int res = 0;
        for (int i = 0, o = 0; i < N; i++) {
            o += nums[i] % 2;
            if (o >= k) {
                res += cnt[o - k];
            }
            cnt[o]++;
        }
        return res;
    }
}

class Solution1 {
    public int numberOfSubarrays(int[] nums, int k) {
        final int N = nums.length;
        final var odds = new ArrayList<Integer>();
        // lower bound
        odds.add(-1);
        for (int i = 0; i < N; i++) {
            if (nums[i] % 2 > 0) {
                odds.add(i);
            }
        }
        final int M = odds.size();
        // upper bound
        odds.add(N);
        int res = 0;
        for (int l = 0, r = k; r < M; l++, r++) {
            res += (odds.get(l + 1) - odds.get(l)) * (odds.get(r + 1) - odds.get(r));
        }
        return res;
    }
}