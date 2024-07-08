class DP {
    public int findTheWinner(int n, int k) {
        int res = 0;
        for (int player = 2; player <= n; player++) {
            res = (res + k) % player;
        }
        return res + 1;
    }
}

class UsingList {
    public int findTheWinner(int n, int k) {
        final var list = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int curr = 0;
        k--;
        while (list.size() > 1) {
            int next = (curr + k) % list.size();
            list.remove(next);
            curr = next;
        }
        return list.getFirst();
    }
}