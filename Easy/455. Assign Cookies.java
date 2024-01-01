class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        for (int i = 0; i < s.length && cnt < g.length; i++) {
            if (s[i] >= g[cnt]) {
                cnt++;
            }
        }
        return cnt;
    }
}