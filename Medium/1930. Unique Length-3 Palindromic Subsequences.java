import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> startAndEnd = new HashSet<>();
        int numOfUniqueSeq = 0;
        for (int l = 0; l < s.length(); l++) {
            if (startAndEnd.contains(s.charAt(l))) {
                continue;
            }
            startAndEnd.add(s.charAt(l));
            for (int r = s.length() - 1; r >= l + 2; r--) {
                if (s.charAt(r) != s.charAt(l)) {
                    continue;
                }
                Set<Character> uniqueMids = new HashSet<>();
                for (int m = r - 1; m > l && uniqueMids.size() < 26; m--) {
                    uniqueMids.add(s.charAt(m));
                }
                numOfUniqueSeq += uniqueMids.size();
                break;
            }
        }
        return numOfUniqueSeq;
    }
}