class Solution {
    public int longestIdealString(String s, int k) {
        final var map = new int[26];
        for (var c : s.toCharArray()) {
            int curr = c - 'a';
            int currMax = 0;
            for (int i = Math.max(0, curr - k); i <= Math.min(25, curr + k); i++) {
                currMax = Math.max(currMax, map[i]);
            }
            map[curr] = currMax + 1;
        }
        return Arrays.stream(map).max().getAsInt();
    }
}