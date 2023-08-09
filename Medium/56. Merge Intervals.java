class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        LinkedList<int[]> li = new LinkedList<>();
        li.add(intervals[0]);
        for (int[] interval : intervals) {
            if (interval[0] <= li.getLast()[1]) {
                if (interval[1] > li.getLast()[1]) {
                    li.getLast()[1] = interval[1];
                }
            } else {
                li.add(interval);
            }
        }
        return li.toArray(new int[li.size()][]);
    }
}