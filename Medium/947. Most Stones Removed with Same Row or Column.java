class Solution {
    private int numOfIslands = 0;

    public int removeStones(int[][] stones) {
        final var parent = new int[20003];
        for (var stone : stones) {
            unionSets(stone[0] + 1, stone[1] + 10002, parent);
        }
        return stones.length - numOfIslands;
    }

    private void unionSets(int a, int b, int[] parent) {
        int parA = findParent(a, parent);
        int parB = findParent(b, parent);
        if (parA != parB) {
            parent[parB] = parA;
            numOfIslands--;
        }
    }

    private int findParent(int node, int[] parent) {
        if (parent[node] == 0) {
            parent[node] = node;
            numOfIslands++;
        }
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = findParent(parent[node], parent);
    }
}