class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1)
            return false;
        Map<Integer, Set<Integer>> hm = new HashMap<>();
        for (int stone : stones)
            hm.put(stone, new HashSet<>());
        hm.get(1).add(1);
        for (int stone : stones) {
            for (int dist : hm.get(stone)) {
                if (dist > 1 && hm.containsKey(stone + dist - 1))
                    hm.get(stone + dist - 1).add(dist - 1);
                if (hm.containsKey(stone + dist))
                    hm.get(stone + dist).add(dist);
                if (hm.containsKey(stone + dist + 1))
                    hm.get(stone + dist + 1).add(dist + 1);
            }
        }
        return hm.get(stones[stones.length - 1]).isEmpty() ? false : true;
    }
}