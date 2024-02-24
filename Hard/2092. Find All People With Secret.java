class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Set<Integer> known = new HashSet<>(List.of(0, firstPerson));
        List<List<int[]>> sortedMeetings = new ArrayList<>();
        Arrays.sort(meetings, (x, y) -> x[2] - y[2]);
        Set<Integer> seenTime = new HashSet<>();

        for (int[] meeting : meetings) {
            if (!seenTime.contains(meeting[2])) {
                seenTime.add(meeting[2]);
                sortedMeetings.add(new ArrayList<>());
            }
            sortedMeetings.get(sortedMeetings.size() - 1).add(new int[] { meeting[0], meeting[1] });
        }

        for(List<int[]> meetingGroup : sortedMeetings) {
            Set<Integer> peopleKnowSecret = new HashSet<>();
            Map<Integer, List<Integer>> graph = new HashMap<>();

            for (int[] p : meetingGroup) {
                graph.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
                graph.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
                if (known.contains(p[0])) {
                    peopleKnowSecret.add(p[0]);
                }
                if (known.contains(p[1])) {
                    peopleKnowSecret.add(p[1]);
                }
            }

            Deque<Integer> queue = new ArrayDeque<>(peopleKnowSecret);

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                known.add(curr);
                for (int neighbour : graph.get(curr)) {
                    if (!known.contains(neighbour)) {
                        known.add(neighbour);
                        queue.offer(neighbour);
                    }
                }
            }
        }
        return List.copyOf(known);
    }
}