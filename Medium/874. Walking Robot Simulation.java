import java.util.HashSet;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        final var obsSet = new HashSet<Integer>();
        for (var obs : obstacles) {
            obsSet.add(obs[0] + obs[1] * 600001);
        }
        final var dirs = new int[] { 0, 1, 0, -1, 0 };
        int currDir = 0, currX = 0, currY = 0;
        int res = 0;
        for (int com : commands) {
            if (com == -1) {
                currDir = (currDir + 1) % 4;
                continue;
            }
            if (com == -2) {
                currDir = (currDir + 3) % 4;
                continue;
            }
            for (int i = 0; i < com; i++) {
                int nextX = currX + dirs[currDir], nextY = currY + dirs[currDir + 1];
                if (obsSet.contains(nextX + nextY * 600001)) {
                    break;
                }
                currX = nextX;
                currY = nextY;
            }
            res = Math.max(res, currX * currX + currY * currY);
        }
        return res;
    }
}