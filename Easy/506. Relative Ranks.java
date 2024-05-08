class Solution {
    public String[] findRelativeRanks(int[] score) {
        final int N = score.length;
        final var pq = new PriorityQueue<Integer>((x, y) -> Integer.compare(score[y], score[x]));
        for (int i = 0; i < N; i++) {
            pq.offer(i);
        }
        final var res = new String[N];
        for (int i = 1; i <= N; i++) {
            if (i > 3) {
                res[pq.poll()] = Integer.toString(i);
            } else {
                if (i == 1) {
                    res[pq.poll()] = "Gold Medal";
                } else if (i == 2) {
                    res[pq.poll()] = "Silver Medal";
                } else {
                    res[pq.poll()] = "Bronze Medal";
                }
            }
        }
        return res;
    }
}