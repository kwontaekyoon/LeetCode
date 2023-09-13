// class Solution {
//     public int candy(int[] ratings) {
//         int candies = ratings.length;
//         int[] dp = new int[ratings.length];
//         Arrays.fill(dp, 1);
//         for (int i = 1; i < ratings.length; i++) {
//             if (ratings[i] < ratings[i - 1]) {
//                 if (dp[i - 1] == 1) {
//                     for (int j = i - 1; j >= 0; j--) {
//                         if (ratings[j] > ratings[j + 1] && dp[j] <= dp[j + 1]) {
//                             dp[j] += 1;
//                             candies += 1;
//                         } else {
//                             break;
//                         }
//                     }
//                 }
//             } else if (ratings[i] > ratings[i - 1]){
//                 dp[i] += dp[i - 1];
//                 candies += dp[i - 1];
//             }
//         }
//         return candies;
//     }
// }
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int sum = len;
        // left to right
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i - 1];
            }
        }
        // right to left
        for (int i = len - 2; i > -1; i--) {
            if (ratings[i] > ratings[i + 1] && dp[i] <= dp[i + 1]) {
                sum += (dp[i + 1] + 1 - dp[i]);
                dp[i] = dp[i + 1] + 1;
            }
        }
        return sum;
    }
}