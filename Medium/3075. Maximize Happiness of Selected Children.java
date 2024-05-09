class Sorting {
    public long maximumHappinessSum(int[] happiness, int k) {
        final int N = happiness.length;
        Arrays.sort(happiness);
        var res = 0L;
        for (int i = N - 1, o = 0; i > N - 1 - k; i--, o++) {
            int cur = happiness[i] - o;
            if (cur > 0) {
                res += cur;
            } else {
                break;
            }
        }
        return res;
    }
}