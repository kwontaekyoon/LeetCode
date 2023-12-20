class Solution {
    public int buyChoco(int[] prices, int money) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < first) {
                second = first;
                first = price;
            } else if (price < second) {
                second = price;
            }
        }
        return (money - first - second < 0) ? money : (money - first - second);
    }
}