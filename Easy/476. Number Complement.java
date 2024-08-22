class Solution1 {
    public int findComplement(int num) {
        int bitLength = Integer.toBinaryString(num).length();
        int mask = (1 << bitLength) - 1;
        return num ^ mask;
    }
}

class Solution {
    public int findComplement(int num) {
        int n = (int) (Math.pow(2, digits(num)) - 1);
        return n - num;
    }

    private int digits(int n) {
        int c = 0;
        while (n > 0) {
            n = n / 2;
            c++;
        }
        return c;
    }
}