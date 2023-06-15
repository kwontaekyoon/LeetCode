class Solution {
    public String longestCommonPrefix(String[] strs) {
        String answer = "";
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }
        out: for (int i = 0; i < minLen; i++) {
            char current = strs[0].charAt(i);
            for(String s : strs) {
                if (current != (s.charAt(i))) {
                    break out;
                }
            }
            answer += String.valueOf(current);
        }
        return answer;
    }
}