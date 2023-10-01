class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (String w : s.split(" ")) {
            StringBuilder tmp = new StringBuilder(w);
            sb.append(tmp.reverse());
            sb.append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}