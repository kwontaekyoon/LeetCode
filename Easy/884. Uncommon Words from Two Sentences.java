import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        final var map = new HashMap<String, Integer>();
        for (var word : s1.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (var word : s2.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        final var res = new ArrayList<String>();
        for (var entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }
        return res.toArray(new String[res.size()]);
    }
}

class Solution1 {
    public String[] uncommonFromSentences(String s1, String s2) {
        final var map1 = new HashMap<String, Integer>();
        final var map2 = new HashMap<String, Integer>();
        for (var word : s1.split(" ")) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }
        for (var word : s2.split(" ")) {
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }
        final var res = new ArrayList<String>();
        for (var entry : map1.entrySet()) {
            if (entry.getValue() != 1 || map2.containsKey(entry.getKey())) {
                continue;
            }
            res.add(entry.getKey());
        }
        for (var entry : map2.entrySet()) {
            if (entry.getValue() != 1 || map1.containsKey(entry.getKey())) {
                continue;
            }
            res.add(entry.getKey());
        }
        return res.toArray(new String[res.size()]);
    }
}