class Solution {
    public List<Integer> getRow(int R) {
        List<List<Integer>> pas = new ArrayList<>(R + 1);
        for (int r = 0; r < R + 1; r++) {
            pas.add(new ArrayList<>(r + 1));
            for (int c = 0; c < r + 1; c++) {
                if (c == 0 || c == r) {
                    pas.get(r).add(1);
                } else {
                    pas.get(r).add(pas.get(r - 1).get(c - 1) + pas.get(r - 1).get(c));
                }
            }
        }
        return pas.get(R);
    }
}