class Solution {
    private boolean checkTilEnd(String s, int size) {
        if (s.length() % size != 0)
            return false;
        String sub = s.substring(0, size);
        for (int i = size; i <= s.length() - size; i += size) {
            if (!s.substring(i, i + size).equals(sub))
                return false;
        }
        return true;
    }

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (checkTilEnd(s, i))
                return true;
        }
        return false;
    }
}