// class Solution {
//     public int maxProfit(int[] prices, int fee) {
//         int[][] DP = new int[prices.length + 1][prices.length + 1];
//         for (int row = 1; row <= prices.length; row++) {
//             for (int col = row + 1; col <= prices.length; col++) {
//                 DP[row][col] = Math.max(prices[col - 1] - prices[row - 1] - 2 + DP[row - 1][col - 2],
//                     DP[row - 1][col]);
//             }
//         }
//         for (int[] row : DP) {
//             System.out.println(Arrays.toString(row));
//         }
//         return 0;
//     }
// }
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;

        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }

        return sell;
    }
}

// dp fucking hard