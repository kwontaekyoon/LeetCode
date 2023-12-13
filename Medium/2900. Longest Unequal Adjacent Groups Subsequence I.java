class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        for (int i = 0, b = -1; i < n; i++) {
            if (groups[i] != b) {
                b = groups[i];
                ans.add(words[i]);
            }
        }
        return ans;
    }
}