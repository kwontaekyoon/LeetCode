class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (x, y) -> x[0] - y[0]);
        long[] rooms = new long[n];
        int[] freqs = new int[n];
        for (int[] meeting : meetings) {
            long earliestTime = Long.MAX_VALUE;
            int earliestSlot = -1;
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (rooms[i] < earliestTime) {
                    earliestSlot = i;
                    earliestTime = rooms[i];
                }
                if (rooms[i] <= meeting[0]) {
                    flag = true;
                    freqs[i]++;
                    rooms[i] = meeting[1];
                    break;
                }
            }
            if (!flag) {
                rooms[earliestSlot] += (meeting[1] - meeting[0]);
                freqs[earliestSlot]++;
            }
        }
        int bookCount = -1;
        int mostBooked = -1;
        for (int i = 0; i < n; i++) {
            if (freqs[i] > bookCount) {
                mostBooked = i;
                bookCount = freqs[i];
            }
        }
        return mostBooked;
    }
}