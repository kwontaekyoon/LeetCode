class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        // accumulate travel time
        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }

        // find last g, p, m appears
        int cnt = 0;

        for (int i = 0; i < garbage.length; i++) {
            cnt += garbage[i].length();
        }

        // last G
        for (int i = garbage.length - 1; i > 0; i--) {
            if (garbage[i].contains("G")) {
                cnt += travel[i - 1];
                break;
            }
        }

        // last P
        for (int i = garbage.length - 1; i > 0; i--) {
            if (garbage[i].contains("P")) {
                cnt += travel[i - 1];
                break;
            }
        }

        // last M
        for (int i = garbage.length - 1; i > 0; i--) {
            if (garbage[i].contains("M")) {
                cnt += travel[i - 1];
                break;
            }
        }

        return cnt;
    }
}