class Solution {
    public int minMoves(int target, int doubles) {
        int moves = 0;
        while (target > 1 && doubles > 0) {
            while (target % 2 == 0 && doubles > 0) {
                target /= 2;
                doubles--;
                moves++;
            }
            target--;
            moves++;
        }
        return moves + target - 1;
    }
}