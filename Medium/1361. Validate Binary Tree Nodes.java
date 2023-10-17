class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = -1;
        int[] children = new int[n];
        for (int i : leftChild) {
            if (i != -1 && ++children[i] == 2) {
                return false;
            }
        }
        for (int i : rightChild) {
            if (i != -1 && ++children[i] == 2) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            if (children[i] == 0) {
                if (root == -1) {
                    root = i;
                } else {
                    return false;
                }
            }
        }
        if (root == -1) {
            return false;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        Set<Integer> hs = new HashSet<>();
        dq.offerLast(root);
        while (dq.size() != 0) {
            int now = dq.pollFirst();
            if (hs.contains(now)) {
                return false;
            }
            hs.add(now);
            if (leftChild[now] != -1) {
                dq.offerLast(leftChild[now]);
            }
            if (rightChild[now] != -1) {
                dq.offerLast(rightChild[now]);
            }
        }
        return hs.size() == n;
    }
}

// class Solution {
// private boolean dfs(int now, int[] leftChild, int[] rightChild, boolean[]
// visited) {
// if (visited[now]) return false;
// visited[now] = true;
// boolean left = (leftChild[now] == -1) ? true : dfs(leftChild[now], leftChild,
// rightChild, visited);
// boolean right = (rightChild[now] == -1) ? true : dfs(rightChild[now],
// leftChild, rightChild, visited);
// return left && right;
// }
// private boolean checkVisit(boolean[] visited) {
// for (boolean visit : visited) {
// if (!visit) return false;
// }
// return true;
// }
// public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[]
// rightChild) {
// // go to head
// int head = 0;
// boolean[] visited = new boolean[n];
// out: while (true) {
// for (int i = 0; i < leftChild.length; i++) {
// if (leftChild[i] == head) {
// if (visited[i]) {
// break out;
// } else {
// visited[i] = true;
// head = i;
// continue out;
// }
// }
// }
// for (int i = 0; i < rightChild.length; i++) {
// if (rightChild[i] == head) {
// if (visited[i]) {
// break out;
// } else {
// visited[i] = true;
// head = i;
// continue out;
// }
// }
// }
// break;
// }
// visited = new boolean[n];
// return dfs(head, leftChild, rightChild, visited) && checkVisit(visited);
// }
// }