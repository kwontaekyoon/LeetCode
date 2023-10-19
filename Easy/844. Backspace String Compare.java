class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder S = new StringBuilder(), T = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                S.append(c);
            } else if (S.length() > 0) {
                S.setLength(S.length() - 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (c != '#') {
                T.append(c);
            } else if (T.length() > 0) {
                T.setLength(T.length() - 1);
            }
        }
        return S.toString().equals(T.toString());
    }
}