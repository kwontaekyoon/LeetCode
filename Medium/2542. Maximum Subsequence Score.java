class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        final int N = nums1.length;
        final var pairs = new int[N][2];
        for (int i = 0; i < N; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        Arrays.sort(pairs, (x, y) -> Integer.compare(y[0], x[0]));
        final var minHeap = new PriorityQueue<int[]>(
                (x, y) -> Integer.compare(x[1], y[1]));
        var curSum = 0L;
        var curMax = 0L;
        for (var pair : pairs) {
            curSum += pair[0];
            minHeap.offer(pair);
            if (minHeap.size() == k) {
                curMax = Math.max(curMax, curSum * minHeap.peek()[1]);
                curSum -= minHeap.poll()[0];
            }
        }
        return curMax;
    }
}