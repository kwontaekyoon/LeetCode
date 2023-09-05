class Solution {
    private int helper(int n) {
        int ans = 0;
        while (n != 0) {
            ans += Math.pow(n % 10, 2);
            n /= 10;
        }
        return ans;
    }

    public boolean isHappy(int n) {
        Set<Integer> hs = new HashSet<>();
        while (!hs.contains(n)) {
            hs.add(n);
            n = helper(n);
        }
        return hs.contains(1);
    }
}