class Solution {
    public boolean rotateString(String s, String t) {
        return s.length() == t.length() && (s + s).contains(t);
    }
}
