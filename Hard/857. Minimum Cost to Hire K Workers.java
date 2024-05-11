class MaxHeapAndSorting {
    private class Worker {
        private int quality;
        private int wage;
        private double wagePerQuality;

        private Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.wagePerQuality = (double) wage / quality;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        final int N = wage.length;
        final var workers = new ArrayList<Worker>();
        for (int i = 0; i < N; i++) {
            workers.add(new Worker(quality[i], wage[i]));
        }
        workers.sort(Comparator.comparingDouble(p -> p.wagePerQuality));
        final var maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        int qualitySum = 0;
        var minCost = Double.MAX_VALUE;
        for (var worker : workers) {
            qualitySum += worker.quality;
            maxHeap.offer(worker.quality);
            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, qualitySum * worker.wagePerQuality);
                qualitySum -= maxHeap.poll();
            }
        }
        return minCost;
    }
}

class BruteForce {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        final int N = wage.length;
        var minCost = Double.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            var currMinCost = 0.0;
            var list = new ArrayList<Double>();
            for (int j = 0; j < N; j++) {
                var currMinWage = (double) quality[j] / quality[i] * wage[i];
                if (currMinWage >= wage[j]) {
                    list.add(currMinWage);
                }
            }
            if (list.size() < k) {
                continue;
            }
            Collections.sort(list);
            for (int l = 0; l < k; l++) {
                currMinCost += list.get(l);
            }
            minCost = Math.min(minCost, currMinCost);
        }
        return minCost;
    }
}