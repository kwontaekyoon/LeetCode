class Solution {
    public long minimumSteps(String s) {
        int upperBound = s.length() - 1;
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) == '0') {
                break;
            }
            upperBound--;
        }
        long totalSteps = 0L;
        for (int i = upperBound; i > -1; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            totalSteps += (upperBound - i);
            upperBound--;
        }
        return totalSteps;
    }
}