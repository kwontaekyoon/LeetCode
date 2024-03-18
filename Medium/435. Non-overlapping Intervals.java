class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[1], y[1]));
        int[] prev = { Integer.MIN_VALUE, Integer.MIN_VALUE };
        int cnt = 0;
        for (int[] curr : intervals) {
            if (curr[0] >= prev[1]) {
                cnt++;
                prev = curr;
            }
        }
        return intervals.length - cnt;
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        int cnt = 0;
        int end = Integer.MIN_VALUE;
        for (int[] cur : intervals) {
            if (cur[0] >= end) {
                end = cur[1];
            } else {
                end = Math.min(cur[1], end);
                cnt++;
            }
        }
        return cnt;
    }
}