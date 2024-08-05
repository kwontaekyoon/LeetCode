import java.util.HashMap;
import java.util.HashSet;

class Solution1 {
    public String kthDistinct(String[] arr, int k) {
        var distinct = new HashSet<String>();
        var nonDistinct = new HashSet<String>();
        int distinctCnt = 0;
        for (var s : arr) {
            if (nonDistinct.contains(s)) {
                continue;
            }
            if (distinct.contains(s)) {
                distinct.remove(s);
                nonDistinct.add(s);
                distinctCnt--;
                continue;
            }
            distinct.add(s);
            distinctCnt++;
        }
        if (distinctCnt < k) {
            return "";
        }
        for (var s : arr) {
            if (nonDistinct.contains(s)) {
                continue;
            }
            if (--k == 0) {
                return s;
            }
        }
        return "";
    }
}

class Solution {
    public String kthDistinct(String[] arr, int k) {
        var map = new HashMap<String, Integer>();
        for (var s : arr) {
            map.put(s, map.containsKey(s) ? -1 : 1);
        }
        for (var s : arr) {
            if (map.get(s) < 0) {
                continue;
            }
            if (--k == 0) {
                return s;
            }
        }
        return "";
    }
}