class Solution {
    public int totalMoney(int days) {
        int currentWeek = 1;
        int prefixSum = 0;
        for (int i = 1; i < 8; i++) {
            prefixSum += i;
        }
        int totalMoney = 0;
        while (days / 7 > 0) {
            totalMoney += prefixSum;
            prefixSum += 7;
            currentWeek += 1;
            days -= 7;
        }
        for (int i = currentWeek; i < currentWeek + days; i++) {
            totalMoney += i;
        }
        return totalMoney;
    }
}