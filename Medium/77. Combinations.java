class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    private void makeCombinations(int n, int k, int start, List<Integer> c) {
        if (c.size() == k) {
            answer.add(new ArrayList<>(c));
        } else {
            for (int i = start; i <= n; i++) {
                c.add(i);
                makeCombinations(n, k, i + 1, c);
                c.remove(c.size() - 1);
            }
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        makeCombinations(n, k, 1, new ArrayList<>());
        return answer;
    }
}