class Solution {
    public int minAddToMakeValid(String s) {
        int opens = 0, unbalanced = 0;
        for (var c : s.toCharArray()) {
            if (c == '(') {
                opens++;
            } else {
                if (opens > 0) {
                    opens--;
                } else {
                    unbalanced++;
                }
            }
        }
        return unbalanced + opens;
    }
}