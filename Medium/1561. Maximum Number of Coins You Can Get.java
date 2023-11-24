class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length / 3;
        int maxCoins = 0;
        Arrays.sort(piles);
        for (int i = n; i < 3 * n; i += 2) {
            maxCoins += piles[i];
        }
        return maxCoins;
    }
}