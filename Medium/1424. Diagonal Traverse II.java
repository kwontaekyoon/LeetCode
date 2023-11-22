class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> diagonalToNums = new HashMap<>();
        int n = 0;
        for (int r = nums.size() - 1; r > -1; r--) {
            List<Integer> row = nums.get(r);
            for (int c = 0; c < row.size(); c++) {
                diagonalToNums.computeIfAbsent(r + c, k -> new ArrayList<>()).add(row.get(c));
                n++;
            }
        }
        int[] res = new int[n];
        int sum = 0, idx = 0;
        while (idx < n) {
            List<Integer> row = diagonalToNums.get(sum);
            for (int i = 0; i < row.size(); i++) {
                res[idx + i] = row.get(i);
            }
            idx += row.size();
            sum++;
        }
        return res;
    }
}

// class Solution {
// public int[] findDiagonalOrder(List<List<Integer>> nums) {
// PriorityQueue<int[]> minHeap = new PriorityQueue<>((x, y) -> {
// if (x[0] + x[1] == y[0] + y[1]) {
// return y[0] - x[0];
// } else {
// return (x[0] + x[1]) - (y[0] + y[1]);
// }
// });
// for (int i = 0; i < nums.size(); i++) {
// for (int j = 0; j < nums.get(i).size(); j++) {
// minHeap.offer(new int[] { i, j });
// }
// }
// int[] res = new int[minHeap.size()];
// for (int i = 0; i < res.length; i++) {
// int[] idx = minHeap.poll();
// res[i] = nums.get(idx[0]).get(idx[1]);
// }
// return res;
// }
// }