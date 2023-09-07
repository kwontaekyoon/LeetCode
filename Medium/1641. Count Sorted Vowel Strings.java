class Solution {
    public int countVowelStrings(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        for (int k = 1; k < n; k++) {
            a += e + i + o + u;
            e += i + o + u;
            i += o + u;
            o += u;
        }
        return a + e + i + o + u;
    }
}

// class Solution {
// private int res = 0;
// private void itertool(int start, int idx, int target) {
// if (idx == target) {
// res++;
// } else {
// for (int i = start; i < 5; i++) {
// itertool(i, idx + 1, target);
// }
// }
// }
// public int countVowelStrings(int n) {
// itertool(0, 0, n);
// return res;
// }
// }