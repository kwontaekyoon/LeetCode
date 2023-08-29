class Solution {
    public int bestClosingTime(String customers) {
        char[] customersToChars = customers.toCharArray();
        int minPen = 0, bestTime = 0;
        for (char c : customersToChars) {
            if (c == 'Y') {
                minPen++;
            } else {
                minPen--;
            }
        }
        int currPen = minPen;
        for (int time = 1; time <= customersToChars.length; time++) {
            if (customersToChars[time - 1] == 'Y') {
                currPen--;
            } else {
                currPen++;
            }
            if (currPen < minPen) {
                bestTime = time;
                minPen = currPen;
            }
        }
        return bestTime;
    }
}