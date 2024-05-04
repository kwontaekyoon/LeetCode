class Counting {
    public int numRescueBoats(int[] people, int limit) {
        final var counts = new int[limit + 1];
        for (int w : people) {
            counts[w]++;
        }
        final var boats = new ArrayDeque<Integer>();
        int fullBoats = 0;
        for (int i = limit; i > 0; i--) {
            while (counts[i] > 0) {
                if (boats.isEmpty() || boats.peekLast() - i < 0) {
                    boats.offerLast(limit - i);
                } else {
                    boats.pollLast();
                    fullBoats++;
                }
                counts[i]--;
            }
        }
        return boats.size() + fullBoats;
    }
}

class Sorting {
    public int numRescueBoats(int[] people, int limit) {
        final int N = people.length;
        final var slots = new ArrayDeque<Integer>();
        Arrays.sort(people);
        int fullSlots = 0;
        for (int i = N - 1; i > -1; i--) {
            if (slots.isEmpty() || slots.peekLast() - people[i] < 0) {
                slots.offerLast(limit - people[i]);
            } else {
                slots.pollLast();
                fullSlots++;
            }
        }
        return fullSlots + slots.size();
    }
}