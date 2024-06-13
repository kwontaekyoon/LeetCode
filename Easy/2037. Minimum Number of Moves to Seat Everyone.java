class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        final int[] SEATS = new int[101], STUDS = new int[101];
        for (int s : seats) {
            SEATS[s]++;
        }
        for (int s : students) {
            STUDS[s]++;
        }
        int minMoves = 0, seat = 0, stud = 0;
        for (int i = 1; i <= 100; i++) {
            seat += SEATS[i];
            stud += STUDS[i];
            minMoves += Math.abs(seat - stud);
        }
        return minMoves;
    }
}