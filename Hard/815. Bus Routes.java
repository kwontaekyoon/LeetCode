class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();

        for (int busId = 0; busId < routes.length; busId++) {
            for (int stop : routes[busId]) {
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(busId);
            }
        }

        if (!stopToBuses.containsKey(source) || !stopToBuses.containsKey(target)) {
            return -1;
        }

        if (source == target) {
            return 0;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> busesTaken = new HashSet<>();
        Set<Integer> stopsVisited = new HashSet<>();
        int cnt = 0;

        queue.offer(source);

        while (!queue.isEmpty()) {
            cnt++;
            int stopsToProcess = queue.size();

            for (int i = 0; i < stopsToProcess; i++) {
                int currentStop = queue.poll();

                for (int busId : stopToBuses.get(currentStop)) {
                    if (busesTaken.contains(busId)) {
                        continue;
                    }

                    busesTaken.add(busId);

                    for (int nextStop : routes[busId]) {
                        if (stopsVisited.contains(nextStop)) {
                            continue;
                        }

                        if (nextStop == target) {
                            return cnt;
                        }

                        queue.offer(nextStop);
                        stopsVisited.add(nextStop);
                    }
                }
            }
        }

        return -1;
    }
}
