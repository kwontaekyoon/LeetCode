import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        final var minHeap = new PriorityQueue<Integer>();
        for (var interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek() < interval[0]) {
                minHeap.poll();
            }
            minHeap.offer(interval[1]);
        }
        return minHeap.size();
    }
}