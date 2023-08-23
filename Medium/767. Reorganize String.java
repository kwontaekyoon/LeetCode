class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray())
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((x, y) -> hm.get(y) - hm.get(x));
        maxHeap.addAll(hm.keySet());
        StringBuilder res = new StringBuilder();
        while (maxHeap.size() >= 2) {
            char char1 = maxHeap.poll();
            char char2 = maxHeap.poll();
            res.append(char1);
            res.append(char2);
            hm.put(char1, hm.get(char1) - 1);
            hm.put(char2, hm.get(char2) - 1);
            if (hm.get(char1) > 0)
                maxHeap.add(char1);
            if (hm.get(char2) > 0)
                maxHeap.add(char2);
        }
        if (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            if (hm.get(c) > 1)
                return "";
            res.append(c);
        }
        return res.toString();
    }
}