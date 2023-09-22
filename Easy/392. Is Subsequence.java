class Solution {
    public boolean isSubsequence(String s, String t) {
        // if (s.isBlank())
        // return true;
        // int p = 0;
        // for (char c : t.toCharArray()) {
        // if (c == s.charAt(p))
        // if (++p == s.length())
        // return true;
        // }
        // return false;

        int pt1 = 0;
        for (int pt2 = 0; pt1 < s.length() && pt2 < t.length(); pt2++) {
            if (s.charAt(pt1) == t.charAt(pt2)) {
                pt1 += 1;
            }
        }
        return pt1 == s.length() ? true : false;
    }
}