class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] colorsToChars = colors.toCharArray();
        int n = colorsToChars.length;
        int sumOfSame = neededTime[0];
        int maxOfSum = neededTime[0];
        int minCost = 0;
        for (int i = 1; i < n; i++) {
            if (colorsToChars[i] == colorsToChars[i - 1]) {
                sumOfSame += neededTime[i];
                maxOfSum = Math.max(neededTime[i], maxOfSum);
            } else {
                minCost += (sumOfSame - maxOfSum);
                sumOfSame = neededTime[i];
                maxOfSum = neededTime[i];
            }
        }
        minCost += (sumOfSame - maxOfSum);
        return minCost;
    }
}