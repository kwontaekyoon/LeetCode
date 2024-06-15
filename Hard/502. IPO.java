class Solution {
    private record Project(int capital, int profit) {
    };

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        final int N = profits.length;
        final var projects = new ArrayList<Project>();
        for (int i = 0; i < N; i++) {
            projects.add(new Project(capital[i], profits[i]));
        }
        Collections.sort(projects, (x, y) -> Integer.compare(x.capital, y.capital));
        final var maxHeap = new PriorityQueue<Integer>((x, y) -> Integer.compare(y, x));
        int i = 0;
        for (int j = 0; j < k; j++) {
            while (i < N && projects.get(i).capital <= w) {
                maxHeap.offer(projects.get(i).profit);
                i++;
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll();
        }
        return w;
    }
}

class TLE {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // do biggest profit at the time
        final int N = profits.length;
        final var done = new boolean[N];
        final var profitAndCapital = new int[N][2];
        for (int i = 0; i < N; i++) {
            profitAndCapital[i][0] = profits[i];
            profitAndCapital[i][1] = capital[i];
        }
        Arrays.sort(profitAndCapital, (x, y) -> {
            if (x[0] == y[0]) {
                return Integer.compare(x[1], y[1]);
            } else {
                return Integer.compare(y[0], x[0]);
            }
        });
        out: while (k > 0) {
            for (int i = 0; i < N; i++) {
                if (done[i]) {
                    continue;
                }
                if (profitAndCapital[i][1] <= w) {
                    w += profitAndCapital[i][0];
                    done[i] = true;
                    k--;
                    continue out;
                }
            }
            break;
        }
        return w;
    }
}