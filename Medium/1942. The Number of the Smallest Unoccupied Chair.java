import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        final int n = times.length;
        final var order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (x, y) -> Integer.compare(times[x][0], times[y][0]));
        final var emptySeats = new PriorityQueue<Integer>((x, y) -> Integer.compare(x, y));
        for (int i = 0; i < n; i++) {
            emptySeats.offer(i);
        }
        final var takenSeats = new PriorityQueue<int[]>((x, y) -> Integer.compare(x[1], y[1]));
        for (int i : order) {
            int arrival = times[i][0], leave = times[i][1];
            while (!takenSeats.isEmpty() && takenSeats.peek()[1] <= arrival) {
                emptySeats.offer(takenSeats.poll()[0]);
            }
            if (i == targetFriend) {
                return emptySeats.poll();
            }
            takenSeats.offer(new int[] { emptySeats.poll(), leave });
        }
        return -1;
    }
}

class Solution1 {
    private class Friend {
        final int number;
        final int time;
        final boolean in;

        private Friend(int number, int time, boolean in) {
            this.number = number;
            this.time = time;
            this.in = in;
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {
        final int n = times.length;
        final var minHeapForChairs = new PriorityQueue<Integer>((x, y) -> Integer.compare(x, y));
        for (int i = 0; i < n; i++) {
            minHeapForChairs.offer(i);
        }
        final var minHeapForFriends = new PriorityQueue<Friend>((x, y) -> {
            if (x.time == y.time) {
                if (!y.in) {
                    return 1;
                } else if (!x.in) {
                    return -1;
                } else {
                    return 0;
                }
            }
            return Integer.compare(x.time, y.time);
        });
        for (int i = 0; i < n; i++) {
            minHeapForFriends.offer(new Friend(i, times[i][0], true));
            minHeapForFriends.offer(new Friend(i, times[i][1], false));
        }
        final var map = new int[n];
        while (!minHeapForFriends.isEmpty()) {
            var curr = minHeapForFriends.poll();
            if (curr.in) {
                if (curr.number == targetFriend) {
                    return minHeapForChairs.peek();
                }
                map[curr.number] = minHeapForChairs.poll();
            } else {
                minHeapForChairs.offer(map[curr.number]);
            }
        }
        return 0;
    }
}