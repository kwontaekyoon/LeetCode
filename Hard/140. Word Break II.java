class Solution {
    private final List<String> res = new ArrayList<>();
    private final List<String> list = new ArrayList<>();
    private final Set<String> dict = new HashSet<>();
    private int N;
    private String S;

    public List<String> wordBreak(String s, List<String> wordDict) {
        S = s;
        N = S.length();
        for (var word : wordDict) {
            dict.add(word);
        }
        backtrack(0);
        return res;
    }

    private void backtrack(int index) {
        if (index == N) {
            res.add(String.join(" ", list));
            return;
        }
        for (int i = index; i < N; i++) {
            if (dict.contains(S.substring(index, i + 1))) {
                list.add(S.substring(index, i + 1));
                backtrack(i + 1);
                list.removeLast();
            }
        }
    }
}