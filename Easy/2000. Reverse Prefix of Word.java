class Solution {
    public String reversePrefix(String word, char ch) {
        var flag = false;
        var sb = new StringBuilder();
        for (var c : word.toCharArray()) {
            sb.append(c);
            if (!flag && c == ch) {
                sb.reverse();
                flag = true;
            }
        }
        return sb.toString();
    }
}