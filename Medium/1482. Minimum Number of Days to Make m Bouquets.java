class BinarySearch {
    public int minDays(int[] bloomDay, int m, int k) {
        final var N = bloomDay.length;
        if ((long) m * k > N) {
            return -1;
        }

        int low = 1, high = 1;
        for (int day : bloomDay) {
            high = Math.max(high, day);
        }

        while (low < high) {
            int mid = (low + high) / 2;

            if (isPossible(bloomDay, m, k, mid, N)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean isPossible(int[] bloomDay, int m, int k, int day, int N) {
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            while (i < N && cnt < k && bloomDay[i] <= day) {
                cnt++;
                i++;
            }

            if (cnt == k) {
                m--;
                i--;
            }

            if (m <= 0) {
                return true;
            }
        }

        return false;
    }
}

class TLE {
    public int minDays(int[] bloomDay, int m, int k) {
        final int N = bloomDay.length;
        if (N < m * k) {
            return -1;
        }
        final var dayToBlooms = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < N; i++) {
            dayToBlooms.computeIfAbsent(bloomDay[i], key -> new ArrayList<>()).add(i);
        }
        final var bloomDays = new ArrayList<Integer>(dayToBlooms.keySet());
        Collections.sort(bloomDays);
        final var bloomed = new boolean[N];
        int flowers = 0;
        for (int day : bloomDays) {
            for (int i : dayToBlooms.get(day)) {
                bloomed[i] = true;
                flowers++;
            }
            if (flowers < m * k) {
                continue;
            }
            if (isPossible(bloomed, m, k)) {
                return day;
            }
        }
        return -1;
    }

    private boolean isPossible(boolean[] bloomed, int m, int k) {
        final var parts = new ArrayList<Integer>();
        parts.add(0);
        int size = 0;
        for (int i = 0; i < bloomed.length; i++) {
            if (bloomed[i]) {
                size++;
            } else {
                if (size > 0) {
                    parts.add(size);
                    size = 0;
                }
            }
        }
        if (size > 0) {
            parts.add(size);
        }
        for (int part : parts) {
            m -= part / k;
        }
        return m <= 0;
    }
}