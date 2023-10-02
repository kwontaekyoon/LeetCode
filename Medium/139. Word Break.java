/**
 * brute force, hash table -> X
 * class Solution {
 * public boolean wordBreak(String s, List<String> wordDict) {
 * Set<String> hs = new HashSet<>();
 * hs.add("");
 * while (!hs.isEmpty()) {
 * Set<String> tmp = new HashSet<>();
 * for (String str : hs) {
 * for (String word : wordDict) {
 * if (str.length() + word.length() <= s.length()) {
 * if (s.substring(str.length(), str.length() + word.length()).equals(word)) {
 * tmp.add(str + word);
 * }
 * }
 * }
 * }
 * hs = tmp;
 * if (hs.contains(s)) {
 * return true;
 * }
 * }
 * return false;
 * }
 * }
 */

// dynamic programig, hash table
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hs = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for (String word : wordDict) {
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
        }
        for (int end = minLen; end <= s.length(); end++) {
            for (int start = end - minLen; start >= Math.max(end - maxLen - 1, 0); start--) {
                if (dp[start] && hs.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}