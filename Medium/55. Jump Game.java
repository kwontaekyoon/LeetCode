class Greedy {
    public boolean canJump(int[] nums) {
        for (int gas = 0, i = 0; i < nums.length; i++, gas--) {
            if (gas < 0) {
                return false;
            }
            if (nums[i] > gas) {
                gas = nums[i];
            }
        }
        return true;
    }
}

class DP {
    public boolean canJump(int[] nums) {
        final int N = nums.length;
        final var DP = new boolean[N];
        DP[0] = true;
        for (int i = 0; i < N && DP[i]; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i; j <= Math.min(N - 1, i + nums[i]); j++) {
                DP[j] = true;
            }
        }
        return DP[N - 1];
    }
}