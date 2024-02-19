class Solution {
    public boolean recursion(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0 || n % 2 != 0) {
            return false;
        }
        return recursion(n / 2);
    }

    public boolean iteration(int n) {
        while (n > 0 && n % 2 == 0) {
            n /= 2;
        }
        return n == 1 ? true : false;
    }

    public boolean bitManipulation(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
