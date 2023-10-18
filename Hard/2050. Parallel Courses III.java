// class Solution {
//     public int minimumTime(int n, int[][] relations, int[] time) {
//         int[] inDegree = new int[n];
//         List<Integer>[] pairing = new ArrayList[n];
//         for (int i = 0; i < n; i++) {
//             pairing[i] = new ArrayList<>();
//         }
//         for (int[] relation : relations) {
//             int prev = relation[0] - 1;
//             int next = relation[1] - 1;
//             pairing[prev].add(next);
//             inDegree[next]++;
//         }
//         int[] dist = new int[n];
//         Deque<Integer> dq = new ArrayDeque<>();
//         for (int i = 0; i < n; i++) {
//             if (inDegree[i] == 0) {
//                 dq.offerLast(i);
//                 dist[i] = time[i];
//             }
//         }
//         while(!dq.isEmpty()) {
//             int prev = dq.pollFirst();
//             for (int next : pairing[prev]) {
//                 dist[next] = Math.max(dist[next], dist[prev] + time[next]);
//                 if (--inDegree[next] == 0) {
//                     dq.offerLast(next);
//                 }
//             }
//         }
//         int minTime = 0;
//         for (int t : dist) {
//             minTime = Math.max(minTime, t);
//         }
//         return minTime;
//     }
// }

public class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] relation : relations) {
            int prev = relation[0] - 1;
            int next = relation[1] - 1;
            graph.get(next).add(prev);
        }

        int[] memo = new int[n];
        int overallMinTime = 0;

        for (int i = 0; i < n; i++) {
            overallMinTime = Math.max(overallMinTime, calculateTime(i, graph, time, memo));
        }

        return overallMinTime;
    }

    private int calculateTime(int course, List<List<Integer>> graph, int[] time, int[] memo) {
        if (memo[course] != 0) {
            return memo[course];
        }

        int maxPrerequisiteTime = 0;
        for (int prereq : graph.get(course)) {
            maxPrerequisiteTime = Math.max(maxPrerequisiteTime, calculateTime(prereq, graph, time, memo));
        }

        memo[course] = maxPrerequisiteTime + time[course];
        return memo[course];
    }
}