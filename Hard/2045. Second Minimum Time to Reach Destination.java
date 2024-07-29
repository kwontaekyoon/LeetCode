import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        final var graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        final var deque = new ArrayDeque<int[]>();
        final var visitedNum = new int[n + 1];
        final var timeArr = new int[n + 1];
        Arrays.fill(timeArr, -1);
        deque.offerLast(new int[] { 1, 0 });
        timeArr[0] = 0;

        while (deque.size() > 0) {
            for (int i = deque.size(); i > 0; i--) {
                var cur = deque.pollFirst();
                int nextTime = 0;
                int curLight = cur[1] / change;
                if (curLight % 2 == 0) {
                    nextTime = cur[1] + time;
                } else {
                    nextTime = (curLight + 1) * change + time;
                }
                for (int nextNode : graph.get(cur[0])) {
                    if (visitedNum[nextNode] < 2 && timeArr[nextNode] < nextTime) {
                        deque.offerLast(new int[] { nextNode, nextTime });
                        visitedNum[nextNode]++;
                        timeArr[nextNode] = nextTime;
                        if (nextNode == n && visitedNum[nextNode] == 2) {
                            return nextTime;
                        }
                    }
                }
            }
        }
        return -1;
    }
}