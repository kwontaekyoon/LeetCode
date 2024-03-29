class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        var map = new HashMap<Double, Integer>();
        var cnt = (long) 0;
        for (var rec : rectangles) {
            var WtoH = (double) rec[0] / rec[1];
            var prev = map.getOrDefault(WtoH, 0);
            cnt += prev;
            map.put(WtoH, prev + 1);
        }
        return cnt;
    }
}