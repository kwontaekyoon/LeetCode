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

class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if (idx == -1) {
            return word;
        }

        return new StringBuilder()
                .append(word.substring(0, idx + 1))
                .reverse()
                .append(word.substring(idx + 1, word.length()))
                .toString();
    }
}
