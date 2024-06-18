class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        final int N = profit.length, M = worker.length;
        int maxDiff = 0;
        for (int diff : difficulty) {
            maxDiff = Math.max(maxDiff, diff);
        }
        final var maxProfitByDifficulty = new int[maxDiff + 1];
        for (int i = 0; i < N; i++) {
            maxProfitByDifficulty[difficulty[i]] = Math.max(maxProfitByDifficulty[difficulty[i]], profit[i]);
        }
        for (int i = 1; i <= maxDiff; i++) {
            maxProfitByDifficulty[i] = Math.max(maxProfitByDifficulty[i], maxProfitByDifficulty[i - 1]);
        }
        int totalProfit = 0;
        for (int ability : worker) {
            totalProfit += maxProfitByDifficulty[Math.min(ability, maxDiff)];
        }
        return totalProfit;
    }
}

class Sorting {
    private record Job(int difficulty, int profit) {
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        final int N = profit.length, M = worker.length;
        final var jobs = new Job[N];
        for (int n = 0; n < N; n++) {
            jobs[n] = new Job(difficulty[n], profit[n]);
        }
        Arrays.sort(jobs, (x, y) -> Integer.compare(x.difficulty, y.difficulty));
        Arrays.sort(worker);

        int profitSum = 0, currMax = 0;
        for (int m = 0, n = 0; m < M; m++) {
            while (n < N && jobs[n].difficulty <= worker[m]) {
                currMax = Math.max(currMax, jobs[n].profit);
                n++;
            }
            profitSum += currMax;
        }
        return profitSum;
    }
}