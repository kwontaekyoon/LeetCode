class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        int tmp = 0;
        for (int price : prices) {
            if (price < min)
                min = price;
            tmp = price - min;
            if (ans < tmp)
                ans = tmp;
        }
        return ans;
    }
}