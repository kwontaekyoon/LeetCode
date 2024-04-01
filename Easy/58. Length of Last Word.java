class Solution {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = chars.length - 1; i > -1; i--) {
            if (chars[i] != ' ') {
                count++;
            } else if (count > 0) {
                return count;
            }
        }
        return count;
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        var strings = s.split(" ");
        return strings[strings.length - 1].length();
    }
}