class Solution {

    public List<List<Integer>> findWinners(int[][] matches) {
        int[] losses = new int[100001];
        int max = 0, min = 100001;
        for (int[] match : matches) {
            int w = match[0], l = match[1];
            if (losses[w] == 0) {
                losses[w] = -1;
            }
            if (losses[l] == -1) {
                losses[l] = 1;
            } else {
                losses[l]++;
            }
            max = Math.max(max, w);
            max = Math.max(max, l);
            min = Math.min(min, w);
            min = Math.min(min, l);
        }
        List<Integer> zeroLosses = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (losses[i] == -1) {
                zeroLosses.add(i);
            } else if (losses[i] == 1) {
                oneLoss.add(i);
            }
        }
        return List.of(zeroLosses, oneLoss);
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> playerToLosses = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            playerToLosses.put(winner, playerToLosses.getOrDefault(winner, 0));
            playerToLosses.put(loser, playerToLosses.getOrDefault(loser, 0) + 1);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> pair : playerToLosses.entrySet()) {
            if (pair.getValue() == 0) {
                ans.get(0).add(pair.getKey());
            } else if (pair.getValue() == 1) {
                ans.get(1).add(pair.getKey());
            }
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}