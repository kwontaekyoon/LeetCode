class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int[] tmp = new int[2];
        int cnt = 0;
        char[] sToChars = s.toCharArray();
        char[] goalToChars = goal.toCharArray();
        for (int i = 0; i < sToChars.length; i++) {
            if (sToChars[i] != goalToChars[i]) {
                if (cnt == 2) {
                    return false;
                } else {
                    tmp[cnt] = i;
                    cnt++;
                }
            }
        }
        if (cnt == 2) {
            if (sToChars[tmp[0]] == goalToChars[tmp[1]] && sToChars[tmp[1]] == goalToChars[tmp[0]]) {
                return true;
            } else {
                return false;
            }
        } else if (cnt == 0) {
            Set<Character> set = new HashSet<>();
            for (char c : sToChars) {
                if (set.contains(c)) {
                    return true;
                }
                set.add(c);
            }
        } else {
            return false;
        }
        return false;
    }
}