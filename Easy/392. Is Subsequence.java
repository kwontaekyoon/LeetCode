class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isBlank())
            return true;
        int p = 0;
        for (char c : t.toCharArray()) {
            if (c == s.charAt(p))
                if (++p == s.length())
                    return true;
        }
        return false;
    }
}