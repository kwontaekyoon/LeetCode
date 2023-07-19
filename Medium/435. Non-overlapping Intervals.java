class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x1, x2) -> Integer.compare(x1[1], x2[1]));
        int prev = intervals[0];
        int cnt = intervals.length - 1;
        for (int[] interval : intervals) {
            if (interval[0] >= prev[1]) {
                cnt--;
                prev = interval;
            }
        }
        return cnt;
    }
}