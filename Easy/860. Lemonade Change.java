class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                if (five > 0) {
                    five--;
                } else {
                    return false;
                }
            } else {
                if (ten > 0) {
                    ten--;
                    if (five > 0) {
                        five--;
                    } else {
                        return false;
                    }
                } else {
                    if (five > 2) {
                        five -= 3;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}